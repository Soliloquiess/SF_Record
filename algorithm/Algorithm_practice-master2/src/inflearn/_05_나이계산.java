package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.StringTokenizer;

public class _05_���̰�� {
	 public static void main(String[] args) throws Exception{


	      Calendar cal =Calendar.getInstance();

	      int year = cal.get(Calendar.YEAR);

	      System.out.print("�ֹι�ȣ�� �Է��ϼ���('-' ����):");
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      String id = br.readLine();
	      String birthYear = id.substring(0,2);

	      char ch = id.charAt(7);

	      int age;
	      if(ch < '3') {
	      // '3'�� ���ڿ������� �ƽ�Ű�ڵ� ���ڷ� �ޱ⿡ ��Һ� ����.
	          age = year - (1900 + Integer.parseInt(birthYear)) + 1;
	      }else {
	          age = year - (2000 + Integer.parseInt(birthYear)) + 1;
	      }
	      System.out.println("����� ���̴� "+age);
	      
	      if (id.charAt(7) == '1' || id.charAt(7) == '3') System.out.println("M");
			else System.out.println("W");

	  }//main
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(),"");
//		String regiNum = br.readLine();
//		String year = regiNum.substring(0, 2);
//		String month = regiNum.substring(2, 4);
//		String date = regiNum.substring(4, 6);
//		
//		char gender = regiNum.charAt(7);
//		
//		String str;
//		str = br.readLine();
//
//		a = str.toCharArray();
//		
//		if (gender == '1' || gender == '2') year = 1900 + ((a[0] - 48) * 10 + (a[1] - 48));
//		//A=65 ~Z=90 0=48 9 =57
//		else year = 2000 + ((a[0] - 48) * 10 + (a[1] - 48));
//		age = 2019 - year + 1;
//		System.out.printf("%d ", age);
//		if (gender == '1' || gender == '3') System.out.println("M");
//		else System.out.println("W");
//	}
}