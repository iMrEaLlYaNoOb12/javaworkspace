package com.vastpro.iopackage.main;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class IODemo2 {
	public static void main(String[] args) throws Exception {
		File file = new File("abc.txt");
		String s = file.exists() ? "file exist" : "file does not exist";
		System.out.println(s);
		// FileInputStream fis=new FileInputStream("abc.txt");
		FileReader fis = new FileReader(file);
		FileWriter fos = new FileWriter("copy.txt");

//		System.out.println((char)fis.read());
//		System.out.println((char)fis.read());
//		System.out.println((char)fis.read());
//		System.out.println(fis.read());
//		//System.out.println((char)fis.read());
//		String str=new String(b);
//		System.out.println(str);
		char b[] = new char[8];
		int noofcharread = 0;
		while ((noofcharread = fis.read(b)) != -1) {

			String str = new String(b, 0, noofcharread);
			System.out.println(str);

			fos.write(b, 0, noofcharread);

		}
		// fos.close();

	}
}
