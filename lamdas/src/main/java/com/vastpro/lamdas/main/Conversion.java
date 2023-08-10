package com.vastpro.lamdas.main;

import java.util.ArrayList;
import java.util.List;

public class Conversion {
	public static void main(String[] args) {
		String names[] = { "Gokul", "Sreelash", "Prasanna", "kousalya", "Ganesh" };
		

	}

	public static <T> List<T> convertArrayToList(T array[]) {
		List<T> listOfSomething = new ArrayList<T>();
		for (T t : array) {
			listOfSomething.add(t);
		}
		return listOfSomething;

	}
}
