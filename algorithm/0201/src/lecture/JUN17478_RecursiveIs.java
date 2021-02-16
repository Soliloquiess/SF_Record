package com.live01;

import java.util.Scanner;

public class JUN17478_RecursiveIs {
	static StringBuffer buf;
	
	public static void recursive(int num, String underBar) {
		String temp = underBar;
					
		//��� ���� ���� - Base Case			
		if(num == 0) {
			buf.append(temp + "����Լ��� ������?\n");
			buf.append(temp + "����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����.\n");
			buf.append(temp + "��� �亯�Ͽ���.\n");
			return;
		}
		
		//���-�ݺ�		
		buf.append(temp + "����Լ��� ������?\n");
		buf.append(temp + "�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n");
		buf.append(temp + "���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n");
		buf.append(temp + "���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\n");
			
		underBar += "____";	// ȣ��� �� ���� ������ 2���� ����.
		recursive(num-1, underBar);		
		buf.append(temp + "��� �亯�Ͽ���.\n");// ��� �� ��¹�
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		buf = new StringBuffer();
		
		buf.append("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		
		recursive(N, "");
		System.out.println(buf);
		scan.close();
	}

}
