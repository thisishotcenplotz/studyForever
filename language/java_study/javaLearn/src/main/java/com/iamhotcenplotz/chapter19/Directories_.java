package com.iamhotcenplotz.chapter19;

import java.io.File;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Directories_ {

    public static void main(String[] args) {
        Directories_ directories = new Directories_();
        directories.m1();
        directories.m2();
    }


    // if ./test.txt exist then delete it
    public void m1(){
        File file = new File("./test3.txt");
        if(file.exists()){
            file.delete();
            System.out.println("Done~~~");
        } else {
            System.out.println("failed~~~");
        }
    }

    public void m2(){
        File file = new File("./temp");
        if(file.exists()){
            System.out.println("exist");
        } else {
            System.out.println("does not exist");
            file.mkdirs();
        }
    }
}
