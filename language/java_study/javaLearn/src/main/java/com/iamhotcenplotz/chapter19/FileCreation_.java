package com.iamhotcenplotz.chapter19;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class FileCreation_{

    public void create01(String pathName)  {
        String filePath = "./" + pathName;
        File file = new File(filePath);

        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void create02(File parent,String fileName) throws IOException {
        File file = new File(parent, fileName);
        file.createNewFile();
    }

    public void create03(String parent,String fileName) throws IOException {
        File file = new File(parent, fileName);
        file.createNewFile();
    }

    public static void main(String[] args) throws IOException {

        FileCreation_ fileCreation = new FileCreation_();
        fileCreation.create01("./test.txt");
        fileCreation.create02(new File("./"),"test2.txt");
        fileCreation.create03("./","test3.txt");
    }
}
