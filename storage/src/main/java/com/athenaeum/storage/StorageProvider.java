package com.athenaeum.storage;

import com.athenaeum.storage.builder.RequestBuilder;
import lombok.SneakyThrows;

import static com.athenaeum.storage.builder.RequestBuilder.VariableBuilder;
import static com.athenaeum.storage.builder.RequestBuilder.InputBuilder;

public class StorageProvider {

    @SneakyThrows
    public void kek() {
        new RequestBuilder(StorageType.SQLITE)
                .newTable("kek",
                        new InputBuilder()
                            .input(
                                    VariableBuilder.of("Kek", DataType.BOOLEAN),
                                    VariableBuilder.of("Kek1", DataType.VARCHAR),
                                    VariableBuilder.of("Kek2", DataType.INTEGER)
                            )
                        );
    }

}
