package com.iamhotcenplotz.chapter19.filewriter_;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class FileWriter_ {

    @Test
    public void writeFile01() throws IOException {
        String filePath = "./note.txt";
        FileWriter fw = null;

        try {
            fw = new FileWriter(filePath);

            // 1. write char
            fw.write('H');

            // 2. write char[]
            fw.write(new char[]{'a', 'b', 'c', 'd'});

            // 3. write String
            fw.write(new String("helllo world"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            fw.flush();
            fw.close();
        }
    }
}
