package com.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileCopy {
	public static void main(String[] args) {
		FileInputStream fis;//���Ͽ��� �о���� ��Ʈ��
		FileOutputStream fos;//���Ϸ� ���� ��Ʈ��.
		
		try {
			fis = new FileInputStream("src\\com\\io\\FileCopy.java"); //original
			fos = new FileOutputStream("src\\com\\io\\Copy.java");//copy
			
			for(int i =0;(i=fis.read())!=-1;){//i�� ���� ������ �ڵ尪
				System.out.println(i);//int
				fos.close();
			}
			
			fis.close();
			fos.write();

		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //���� ���Ͽ� ����
	}
}
