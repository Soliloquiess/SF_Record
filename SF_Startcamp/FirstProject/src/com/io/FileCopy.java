package com.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileCopy {
	public static void main(String[] args) {
		FileInputStream fis;//파일에서 읽어오는 스트림
		FileOutputStream fos;//파일로 쓰는 스트림.
		
		try {
			fis = new FileInputStream("src\\com\\io\\FileCopy.java"); //original
			fos = new FileOutputStream("src\\com\\io\\Copy.java");//copy
			
			for(int i =0;(i=fis.read())!=-1;){//i가 읽은 글자의 코드값
				System.out.println(i);//int
				fos.close();
			}
			
			fis.close();
			fos.write();

		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //원본 파일에 연결
	}
}
