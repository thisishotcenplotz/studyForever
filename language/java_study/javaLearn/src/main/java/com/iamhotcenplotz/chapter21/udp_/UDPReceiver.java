package com.iamhotcenplotz.chapter21.udp_;

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

@SuppressWarnings({"all"})
public class UDPReceiver {
    public static void main(String[] args) throws IOException {

        // create DatagramSocket
        DatagramSocket socket = new DatagramSocket(9999);

        // create DatagramePacket to receive data
        // the maximum capacity of UDP package is 64k -> byte[1024 * 64]
        byte[] buffer = new byte[1024]; // 1024 is good enough for our demo
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        // ready to receive data
        socket.receive(packet);

        // parse packet
        int length = packet.getLength();
        byte[] data = packet.getData();

        // display received data
        String message = new String(data, 0, length);
        System.out.println(message);

        // repley message
        byte[] repley = "ok~~ beer tomorrow?".getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet1 = new DatagramPacket(repley, repley.length, InetAddress.getByName("localhost"), 8888);
        socket.send(packet1);
        

        // release socket resource
        socket.close();

    }
}
