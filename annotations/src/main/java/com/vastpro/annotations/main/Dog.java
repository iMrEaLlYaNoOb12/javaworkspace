package com.vastpro.annotations.main;

public class Dog extends Animal {
	@Override
	void eat() {
		System.out.println("Dog is eating...");
	}

	void printDog() {
		System.out.println("I'm Dog...");
	}

	public static void main(String[] args) {
		Animal cat = new Dog();
		cat.eat();

	}
}

class Animal {
	void eat() {
		System.out.println("Animal is eating...");
	}
}

class Cat extends Animal {
	@Override
	void eat() {
		System.out.println("Cat is eating...");
	}

	void printDog() {
		System.out.println("I'm Cat...");
	}
}
