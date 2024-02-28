package org.example;

import java.io.File;

public class Tree {


    public static void print(){
        constructTree(new File("."), "", true);
    }

    public static void constructTree(File file, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else {
            System.out.print("├─");
            indent += "│ ";
        }

        File[] files = file.listFiles();
        if (files == null)
            return;

        System.out.print(file.getName() + " : " + printFileList(files));
        System.out.println();

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
