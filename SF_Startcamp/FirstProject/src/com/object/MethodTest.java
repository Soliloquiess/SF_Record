package com.object;

import com.test.LoopTest;

public class MethodTest {

	//int�� ���� 2���� �Է¹޾� �� ���� ����ϴ� sum()
	static void sum(int a, int b) {	//void �ȳ־��ָ� �ȵ�.
		int c = a+b;
		System.out.println(c);
	}
	static int sum2(int a, int b) {	//����� �����ϴϱ� void ��� int��
		int c = a+b;
		return c;		//return a+b;
	}
	
//	2.reverse(): boolean�� ���� �Ѱ��� �Է¹޾� �� �ݴ밪�� ����
	
	static boolean reverse(boolean a) {	//void �ȳ־��ָ� �ȵ�.
		if(a==true)
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
	
	
//	(true)=>false, false=>true
	
//	3. result(): boolean �� �Ű����� 2����  �޾� a,b��� ���� ��쿡 ok�� �ƴϸ� candel ����
	
	static String result(boolean a, boolean b) {	//void �ȳ־��ָ� �ȵ�.
		if(a==true&&b==true)
		{
			return "ok";
		}
		else 
		{
			return "cancel";
		}
	}
	//4.loopString(): int�� 
	static void loopString(int count, String msg) {	//void �ȳ־��ָ� �ȵ�.
		for(int i=0; i<count;i++) {
			System.out.println(msg);	
		}
	}
	
	static void  getArea(int r)
	{
		double area = 3.14 *r *r;
		System.out.println(area);
	}
	public static void main(String[] args) {
		
//		//�޼��� ���
//		sum(7,8);
//		sum(3,7);
		
		int result = sum2(1,6);
		boolean a = true;
		boolean b = true;
		int num = 3;
		
//		System.out.println(result);
//		System.out.println(sum2(10,33));
		System.out.println(reverse(a));
		System.out.println(result(a,b));
//		System.out.println(loopString(num,"msg"));  �̷��� �ؼ� �ȵƴ���;
		loopString(num, "msg");
//		System.out.println(getArea(3)); �̷��� �ص� ����! ���� �޴°� ���µ� ���� ����ϳİ�! 
//		�׳� �Լ��� �Ű������� �־ �������
		getArea(3);
	}

}
