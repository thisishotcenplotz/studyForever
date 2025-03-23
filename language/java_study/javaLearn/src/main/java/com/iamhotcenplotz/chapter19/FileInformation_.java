package com.iamhotcenplotz.chapter19;

import java.io.File;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class FileInformation_ {
    public static void main(String[] args) {
        FileInformation_ fileInformation = new FileInformation_();
        fileInformation.getInformations("./Hello.java");
    }

    public void getInformations(String pathName){
        File file = new File(pathName);

        System.out.println("file name: " + file.getName());
        System.out.println("is file: " + file.isFile());
        System.out.println("abs path: " + file.getAbsolutePath());
        System.out.println("is folder:" + file.isDirectory());
        System.out.println("parent path:" + file.getParent());
        System.out.println("is exist: " + file.exists());
    }
}
