package org.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Main {
    private static final Random random = new Random();
    private static final int CHAR_BOUND_L = 65;
    private static final int CHAR_BOUND_H = 90;
    public static void main(String[] args) throws IOException {
        writeFileContents("newfile.md", 200);
        Backup backup = new Backup("newfile.md");
        System.out.println(backup.backup("./backup", false));
        Tree.print();
    }

    /**
     * Метод генерации некоторой последовательности символов
     * @param amount кол-во символов
     * @return последовательность символов
     */
    private static String generateSymbols(int amount){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < amount; i++){
            stringBuilder.append((char)random.nextInt(CHAR_BOUND_L, CHAR_BOUND_H + 1));
        }
        return stringBuilder.toString();
    }

    /**
     * Записать последовательность символов в файл
     * @param fileName имя файла
     * @param length длина последовательности символов
     * @throws IOException
     */
    static void writeFileContents(String fileName, int length) throws IOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream(fileName)){
            fileOutputStream.write(generateSymbols(length).getBytes(StandardCharsets.UTF_8));
        }
    }
}