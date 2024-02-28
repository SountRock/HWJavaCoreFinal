package org.example;

import java.io.File;
import java.util.Arrays;

public class Tree {

    public static void print(File file, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast){
            System.out.print("└─");
            indent += "  ";
            //printFileList(file.listFiles());
        }
        else {
            System.out.print("├─");
            indent += "│ ";
            //printFileList(file.listFiles());
        }

        String filesList = printFileList(file.listFiles());
        if(!filesList.equals("")){
            System.out.print(file.getName() + " : " + filesList);
        } else {
            System.out.print(file.getName());
        }
        System.out.println();

        File[] files = file.listFiles();
        if (files == null)
            return;

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
                print(files[i], indent, subDirTotal == ++subDirCounter);
            }
        }

    }

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
