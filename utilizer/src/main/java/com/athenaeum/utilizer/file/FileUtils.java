package com.athenaeum.utilizer.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

    public static String readLinesAsSingle(File file) throws IOException {
        StringBuilder result = new StringBuilder();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null) {
            result.append(" ").append(line);
            line = reader.readLine();
        }

        return result.toString();
    }

}
