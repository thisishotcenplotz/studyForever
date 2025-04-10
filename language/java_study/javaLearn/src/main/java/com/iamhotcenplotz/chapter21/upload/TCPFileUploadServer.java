package com.iamhotcenplotz.chapter21.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws IOException {

        // Server at 8888
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Server started on port 8888...");

        // wait for connect
        Socket socket = serverSocket.accept();

        // read byte[] from client
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] imageBytes = StreamUtils.streamToByteArray(bufferedInputStream);

        // persist imageBytes to local image
        String filePath = "./hfaceee.webp";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
        bufferedOutputStream.write(imageBytes);


        // send receipt to client
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("image saved.\n");
        bufferedWriter.flush();
        socket.shutdownOutput();


        // release resources
        bufferedWriter.close();
        bufferedOutputStream.close();
        bufferedInputStream.close();


        // complete
        socket.close();
        serverSocket.close();

    }
}
