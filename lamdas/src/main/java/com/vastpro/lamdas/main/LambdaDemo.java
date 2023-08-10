package com.vastpro.lamdas.main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LambdaDemo {
	public static void staticMethod() {
		System.out.println("This is a static method using method reference....");
	}

	public void nonStaticMethod() {
		System.out.println("This is a non static method using method reference....");
	}

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		// Normal implementation
		MyInter impl = new MyInterImpl();
		impl.met();

		// Anonymous implementation
		new MyInter() {

			@Override
			public void met() {
				System.out.println("This is anonymous method...");
			}

		}.met();

		// Static method referencing
		MyInter staticMethodImpl = LambdaDemo::staticMethod;
		staticMethodImpl.met();

		// Non static method referencing
		LambdaDemo ld = new LambdaDemo();
		MyInter nonStaticMethodImpl = ld::nonStaticMethod;
		nonStaticMethodImpl.met();

		// Lambda function
		Calculator add = (num1, num2) -> {
			int result = num1 + num2;
			return result;
		};
		Class c = add.getClass();
		Method m = c.getDeclaredMethod("add", int.class, int.class);
		int res = (int) m.invoke(add, 5, 5);
		System.out.println(res);
		int resultAdd = add.add(10, 20);
		System.out.println(resultAdd);

	}
}

class MyInterImpl implements MyInter {

	@Override
	public void met() {
		System.out.println("This is a method...");

	}

}

interface MyInter {
	void met();

}

interface Calculator {
	int add(int num1, int num2);

}