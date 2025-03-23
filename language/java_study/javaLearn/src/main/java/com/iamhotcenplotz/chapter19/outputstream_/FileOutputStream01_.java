package com.iamhotcenplotz.chapter19.outputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class FileOutputStream01_ {

    public static void main(String[] args) {

    }


    /**
     * write file demo
     * */
    @Test
    public void writeFile(){
        String filePath = "temp.txt";
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(filePath);

            // fileOutputStream.write('a');

            String str = "Hello World!!!";
            fileOutputStream.write(str.getBytes());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
