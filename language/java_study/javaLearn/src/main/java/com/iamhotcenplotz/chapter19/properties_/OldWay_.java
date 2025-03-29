package com.iamhotcenplotz.chapter19.properties_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class OldWay_ {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./mysql.properties"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split("=");
            System.out.println(split[0] + "=>>>" + split[1]);
        }

        bufferedReader.close();
    }
}
