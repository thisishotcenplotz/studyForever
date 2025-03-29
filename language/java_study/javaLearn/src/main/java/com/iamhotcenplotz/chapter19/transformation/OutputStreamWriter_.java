package com.iamhotcenplotz.chapter19.transformation;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String outPath = "./test.dat";

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(outPath), "GBK");
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write("Hello How are you. 这个那个 是啥啊");

        bw.close();

    }
}
