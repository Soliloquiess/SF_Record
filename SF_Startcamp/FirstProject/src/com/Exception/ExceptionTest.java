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
			//���� ���� �Է¹޴� ��ü
		}
}
