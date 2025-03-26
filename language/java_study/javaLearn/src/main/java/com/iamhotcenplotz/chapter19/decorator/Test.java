package com.iamhotcenplotz.chapter19.decorator;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {

        // demo 1
        DecoBufferedReader_ decoBufferedReader = new DecoBufferedReader_(new DecoFileReader_());
        decoBufferedReader.readFiles(10);

        // demo 2
        DecoBufferedReader_ decoBufferedReader1 = new DecoBufferedReader_(new DecoStringReader_());
        decoBufferedReader1.readStrings(10);


    }
}
