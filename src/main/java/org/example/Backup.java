package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Backup {
    private String dirFromBackup;

    public Backup(String dirFromBackup) {
        this.dirFromBackup = dirFromBackup;
    }

    /**
     * Метод для копирования файлов в указанную директорию
     * @param backUpFolder
     * @param isOverride если true - будет происходить перезапись файла, что уже был скопирован в ту же директорию с тем же именем, елси false - будет создана новая отдельная папка
     * @return isSuccess
     */
    public boolean backup(String backUpFolder, boolean isOverride){
        try(FileInputStream FROM = new FileInputStream(dirFromBackup)){
            File backUpFile;

            if(!isOverride){
                backUpFolder = backUpFolder + LocalDate.now() +
                        "_" + LocalDateTime.now().getHour() +
                        "_" + LocalDateTime.now().getMinute() +
                        "_" + LocalDateTime.now().getSecond();

                backUpFile = new File(backUpFolder);
                backUpFile.mkdir();
            } else {
                backUpFile = new File(backUpFolder);
                backUpFile.mkdir();
            }

            backUpFile = new File(backUpFolder, dirFromBackup);

            try(FileWriter TO = new FileWriter(backUpFile)){
                int read;
                while ((read = FROM.read()) != -1){
                    TO.write(read);
                }

                return true;
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }
}
