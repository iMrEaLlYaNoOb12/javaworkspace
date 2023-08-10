package com.vastpro.iopackage.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IODemo1 {
	public static void main(String[] args) throws Exception {
		File file = new File("abc.txt");
		String s = file.exists() ? "file exist" : "file does not exist";
		System.out.println(s);
		// FileInputStream fis=new FileInputStream("abc.txt");
		FileInputStream fis = new FileInputStream(file);
		// FileOutputStream fos = new FileOutputStream("copy.txt");
		System.out.println("This is the available characters in the file : " + fis.available());// will tell the size of
			String toStrings = fis.toString();																				// the contents in file

//		System.out.println((char)fis.read());
//		System.out.println((char)fis.read());
//		System.out.println((char)fis.read());
//		System.out.println(f is.read());
//		//System.out.println((char)fis.read());
//		String str=new String(b);
//		System.out.println(str);
		byte b[] = new byte[9];
		int noofcharread = 0;
		while ((noofcharread = fis.read(b)) != -1) {

			String str = new String(b, 0, noofcharread);
			System.out.println(str);

			// fos.write(b, 0, noofcharread);

		}
		fis.close();
		// fos.close();
	}
}
