package com.iamhotcenplotz.chapter19.filewriter_;

import java.io.*;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class BufferedCopy_ {
    public static void main(String[] args) throws Exception{

        // 不要用这个方法去操作二进制文件，可能会造成文件损坏
        String srcPath = "./javaStudy.md";
        String destPath = "./javaStudy2.txt";

        BufferedReader br = null;
        BufferedWriter bw = null;

        String line = null;

        try {
            br = new BufferedReader(new FileReader(srcPath));
            bw = new BufferedWriter(new FileWriter(destPath));

            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (br != null) {
                br.close();
            }

            if (bw != null) {
                bw.close();
            }
        }
    }
}
