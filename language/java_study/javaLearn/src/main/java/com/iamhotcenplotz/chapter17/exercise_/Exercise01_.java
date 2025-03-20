package com.iamhotcenplotz.chapter17.exercise_;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Exercise01_ {
    public static void main(String[] args) {
        Thread thread = new Thread(new RandomNumber());
        thread.setDaemon(true);
        thread.start();


        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("input your command: ");
            char key = scanner.next().toUpperCase().charAt(0);

            if (key == 'Q') {
                break;
            }
        }




    }
}

class RandomNumber implements Runnable{


    private int cnt = 0;
    @Override
    public void run() {
        while (true){
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String ts = LocalDateTime.now().format(dateTimeFormatter);
            int random = (int) (Math.random() * 100);
            
            System.out.println(ts + " :" + random + " ["+cnt+"]");
            cnt++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
