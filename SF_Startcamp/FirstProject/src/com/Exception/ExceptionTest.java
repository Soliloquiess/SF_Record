package com.Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionTest {

		public static void main(String[] args) {
			try {
				FileInputStream fis = new FileInputStream("Hello.txt");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//파일 내용 입력받는 개체
		}
}
