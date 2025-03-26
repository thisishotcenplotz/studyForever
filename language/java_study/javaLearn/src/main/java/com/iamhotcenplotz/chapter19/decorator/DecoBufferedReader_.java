package com.iamhotcenplotz.chapter19.decorator;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class DecoBufferedReader_ extends DecoReader_{
    private DecoReader_ decoReader;

    public DecoBufferedReader_(DecoReader_ decoReader) {
        this.decoReader = decoReader;
    }

    // 拓展，多次读取文件
    public void readFiles(int num) {
        for (int i = 0; i < num; i++) {
            decoReader.readFile();
        }
    }

    // 拓展，批量读取字符串
    public void readStrings(int num) {
        for (int i = 0; i < num; i++) {
            decoReader.readString();
        }
    }



}
