package com.iamhotcenplotz.chapter21.exercises_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Exercise02Receiver_ {
    public static void main(String[] args) throws IOException {

        // get socket
        DatagramSocket socket = new DatagramSocket(8888);

        // receive data preparation
        byte[] buffer = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        // ready to receive question
        socket.receive(packet);

        // unpack packet
        int length = packet.getLength();
        byte[] data = packet.getData();
        String question = new String(data, 0, length);
        System.out.println("question: " + question);

        // answer preparation
        String answer = "";
        if("四大名著".equals(question)) {
            answer = "红楼梦，水浒传，三国演义，西游记";
        } else {
            answer = "啥？";
        }

        // reply
        byte[] answerBytes = answer.getBytes(StandardCharsets.UTF_8);
        DatagramPacket answerPacket = new DatagramPacket(answerBytes, answerBytes.length, InetAddress.getByName("localhost"), 9999);
        socket.send(answerPacket);

        // release resources
        socket.close();


    }
}
