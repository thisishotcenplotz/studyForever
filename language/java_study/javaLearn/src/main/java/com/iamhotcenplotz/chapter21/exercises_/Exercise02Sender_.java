package com.iamhotcenplotz.chapter21.exercises_;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Exercise02Sender_ {
    public static void main(String[] args) throws IOException {

        // get socket
        DatagramSocket socket = new DatagramSocket(9999);

        // question preparation
        byte[] question = "四大名著".getBytes(StandardCharsets.UTF_8);

        // send question
        socket.send(new DatagramPacket(
            question,question.length, InetAddress.getByName("localhost"),8888
        ));

        // receive reply
        byte[] buffer = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);

        // display
        int length = packet.getLength();
        byte[] data = packet.getData();

        String answer = new String(data, 0, length, StandardCharsets.UTF_8);
        System.out.println(answer);

        // release resources
        socket.close();

    }
}
