package com.iamhotcenplotz.chapter21.exercises_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class Exercise01Server_ {
    public static void main(String[] args) throws IOException {
        // create server
        ServerSocket server = new ServerSocket(9999);
        System.out.println("server is online...");
        Socket socket = server.accept();

        //read message from client
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String receive = br.readLine();
        System.out.println(receive);

        // repley preperation
        String answer = "";
        if("name".equals(receive)) {
            answer = "this is hotcenplotz";
        } else if ("hobby".equals(receive)) {
            answer = "flert";
        } else {
            answer = "what are you talking about?";
        }

        // repley
        OutputStream os = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        bw.write(answer);
        bw.newLine();
        bw.flush();

        //release resource
        bw.close();
        os.close();
        br.close();
        is.close();
        socket.close();
        server.close();



    }
}
