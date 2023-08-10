package com.vastpro.annotations.main;

public class NotGate {

	public static void main(String[] args) {
		int a = 5;
		int b = 5;

		a = a ^ b;
		System.out.println(a);
		b = a ^ b;
		System.out.println(b);
	}

}
