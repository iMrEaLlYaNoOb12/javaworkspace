package com.vastpro.annotations.main;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@MyAnno(name = "kamal")
public class KamalAnnoDemo {

	@MyAnno(name = "hello")
	String demo;

	@MyAnno(name = "method")
	void m1() {
		System.out.println();
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, NoSuchFieldException {
		Class c = new KamalAnnoDemo().getClass();
		Method met = c.getDeclaredMethod("m1");
		MyAnno annoMethod = met.getAnnotation(MyAnno.class);
		System.out.println(annoMethod);

		Field f = c.getDeclaredField("demo");
		MyAnno fieldAnno = f.getAnnotation(MyAnno.class);
		System.out.println(fieldAnno);

		MyAnno anno = (MyAnno) c.getAnnotation(MyAnno.class);
		System.out.println(anno);
	}
}

@Target({ ElementType.METHOD, ElementType.TYPE, ElementType.FIELD }) // class mela mattum apply panna mudiyum
@Retention(RetentionPolicy.RUNTIME) // Only source file la apply aagum

//Constructors,Methods,Classes,Fields,Local variable, package, parameter,annotation,
@interface MyAnno {
	String name();
}

@interface