package com.iamhotcenplotz.chapter12.custom;

/** 
 * @author Der Hotcenplotz
 * @version 1.0
 */

public class AgeException extends RuntimeException {
  public AgeException(String message) {
    super(message);
    System.out.println("Oops... something got wrong");
  }
}
