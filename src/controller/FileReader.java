package controller;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Класс FileReader, который выполняет чтение текста из заданного файла
 *
 * @author Александра Малявко
 * @version 2020
 */

public class FileReader {
    public static String read(String filePath) throws IOException {
        File f = new File(filePath);
        Scanner s = new Scanner(f);
        StringBuilder builder = new StringBuilder();
        while (s.hasNextLine()) {
            String st = s.nextLine();
            builder.append(" ").append(st.replaceAll("\s+", " "));
        }
        return builder.toString();
    }
}
