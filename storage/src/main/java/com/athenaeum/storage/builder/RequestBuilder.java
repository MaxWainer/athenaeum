package com.athenaeum.storage.builder;

import com.athenaeum.storage.DataType;
import com.athenaeum.storage.StorageType;
import com.athenaeum.utilizer.file.FileUtils;
import lombok.Getter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class RequestBuilder {

    private final StorageType storageType;
    private String command;

    public RequestBuilder(StorageType storageType) throws Exception {
        if(storageType == StorageType.JSON)
            throw new Exception("Error while building request! Possible fixes: Change storageType to MYSQL or SQL");
        this.storageType = storageType;
    }

    public RequestBuilder command(String s) {
        command = s;
        return this;
    }

    public RequestBuilder db(String s) {
        command += " FROM " + s;
        return this;
    }

    public RequestBuilder select(String... s) {
        command += " SELECT " + String.join(",", s);
        return this;
    }

    public RequestBuilder newTable(String tableName, InputBuilder builder) {
        command = "ALERT TABLE IF NOT EXISTS " + tableName + " " + builder.getFinal();
        return this;
    }

    public final static class InputBuilder {

        private String finalValue;

        public InputBuilder input(VariableBuilder... builder) {
            List<String> returnable = new ArrayList<>();
            Arrays.stream(builder).forEach(e -> {
                returnable.add(e.get());
            });
            finalValue = String.join(", ", returnable);
            return this;
        }

        public String getFinal() {
            return finalValue;
        }

    }

    @Getter
    public final static class VariableBuilder {

        private final String name;

        private DataType type;
        private int size;
        private boolean nullable;

        public VariableBuilder(String name) {
            this.name = name;
        }

        public VariableBuilder size(int size) {
            this.size = size;
            return this;
        }

        public VariableBuilder type(DataType type) {
            this.type = type;
            return this;
        }

        public VariableBuilder isNull(boolean is) {
            nullable = is;
            return this;
        }

        public String get() {
            return "`" + name + "` " + type.name() + (size <= 0 ? "" : "(" + size + ")") + " "
                    + (nullable ? "NULL" : "NOT NULL")
                    ;
        }

        public static VariableBuilder of(String name, DataType type, int size, boolean isNull) {
            return new VariableBuilder(name)
                    .type(type)
                    .size(size)
                    .isNull(isNull);
        }

        public static VariableBuilder of(String name, DataType type) {
            return of(name, type, -1, false);
        }

    }

    public static RequestBuilder of(StorageType type, String command) throws Exception {
        return new RequestBuilder(type).command(command);
    }

    public static RequestBuilder of(String command) throws Exception {
        return of(StorageType.SQLITE, command);
    }

    public static RequestBuilder of(File file) throws Exception {
        return of(StorageType.SQLITE, FileUtils.readLinesAsSingle(file));
    }

    public static RequestBuilder of(StorageType type, File file) throws Exception {
        return of(type, FileUtils.readLinesAsSingle(file));
    }

}
