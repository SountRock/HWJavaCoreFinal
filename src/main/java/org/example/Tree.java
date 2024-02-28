package org.example;

import java.io.File;

/**
 * Класс формирует графическое древо директорий и файлов
 */
public class Tree {

    private static String result = "";

    /**
     * Получить дерево директорий и файлов
     * @param root
     * @return tree to string
     */
    public static String print(File root){
        return constructTree(root, "", true);
    }

    /**
     * Получить дерево директорий и файлов
     * @param file
     * @param indent
     * @param isLast
     * @return tree to string
     */
    private static String constructTree(File file, String indent, boolean isLast){
        result += indent;
        if (isLast){
            result += "└─";
            indent += "  ";
        }
        else {
            result += "└─";
            indent += "│ ";
        }

        File[] files = file.listFiles();
        if (files == null)
            return "";

        result += file.getName() + " : " + printFileList(files) + '\n'; //

        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory())
            {
                subDirTotal++;
            }
        }

        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory())
            {
                constructTree(files[i], indent, subDirTotal == ++subDirCounter);
            }
        }

        return result;
    }

    /**
     * Возвращает все файлы из listFiles
     * @param files
     * @return files
     */
    private static String printFileList(File[] files){
        String filesStr = "";
        for (File f : files) {
            if(f.isFile()){
                filesStr += f.getName() + "; ";
            }
        }

        return filesStr;
    }
}
