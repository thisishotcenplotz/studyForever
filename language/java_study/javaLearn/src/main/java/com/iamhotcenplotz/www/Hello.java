package com.iamhotcenplotz.www;

public class Hello {
	public static void main(String[] args){
		System.out.println("Hello World");
		Hi();
		int numOfHi = yo(3);

		for (int i = 0; i < numOfHi; i++) {
			Hi();
		}
		sayHi();

	}

	public static void Hi(){
		System.out.println("Hi");
	}

	public static int yo(int num){
		return num * 3;
	}

	public static void sayHi(){
		System.out.println("Hi~~~");
	}

}
