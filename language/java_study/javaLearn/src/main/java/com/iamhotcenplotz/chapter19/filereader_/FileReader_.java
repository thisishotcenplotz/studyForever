package com.iamhotcenplotz.chapter19.filereader_;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class FileReader_ {
    @Test
    public void readFile01() throws IOException {

        FileReader fileReader = null;
        int data = ' ';

        try {
            fileReader = new FileReader("./pom.xml");

            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            fileReader.close();
        }

    }

    @Test
    public void readFile02() throws IOException {
        String filePath = "./pom.xml";
        FileReader fileReader = null;

        int readLen = 0;
        char[] buffer = new char[8];

        try{

            fileReader = new FileReader(filePath);

            while ((readLen = fileReader.read(buffer)) != -1){
                System.out.print(new String(buffer, 0, readLen));
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            fileReader.close();
        }
    }
}
