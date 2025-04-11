package com.iamhotcenplotz.chapter21.exercises_;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Exercise01Client_ {
    public static void main(String[] args) throws IOException {
        // socket
        Socket socket = new Socket("localhost", 9999);

        // read message from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter your question: ");
        String question = scanner.nextLine();

        // convert question
        OutputStream os = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

        // send
        bw.write(question);
        bw.newLine();
        bw.flush();

        // receive
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String s = br.readLine();
        System.out.println(s);

        //release resource
        br.close();
        is.close();
        bw.close();
        os.close();
        socket.close();


    }
}
