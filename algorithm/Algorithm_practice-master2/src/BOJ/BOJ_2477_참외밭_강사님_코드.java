package BOJ;

import java.util.Scanner;

public class BOJ_2477_���ܹ�_�����_�ڵ� {

	public static void main(String[] args) {
	{
	
		Scanner sc=  new Scanner(System.in);
		
		
		int K = sc.nextInt();
		int [] a = new int[6];
		for(int i =0; i<6; i++) {
			sc.nextInt();
			a[i] = sc.nextInt();
		}
		int maxWidth = 1;
		int maxHeight = 1;
		
		for(int i =0;i<6;i++) {
			if(i%2==0) {	//¦�������� ����
				if(maxWidth<a[i]) maxWidth =a[i];
//				maxWidth = Math.max(maxWidth, a[i]);
			}
			else {

				if(maxHeight<a[i]) maxHeight =a[i];
//				maxHeight = Math.min(maxHeight, a[i]);
			}
		}

		int Width = 500;
		int Height = 500;
		
		
		for(int i = 0; i<6;i++) {
			if(i%2==0) {	//����+����
				if(maxHeight == a[(i+5)%6]+a[(i+1)%6]) {
					//���� ��ȣ���� 5�� ���ϸ� �� �տ����� ��.���տ��� ã�µ� 5�� ���ؼ� %6�� �ؾ� 
					//�ε��� ��ȣ �ȿ� ����.
					
					
					Width = a[i];
				}
			}else {
				if(maxWidth==a[(i+5)%6]+a[(i+1)%6]) {
					Height = a[i];			
				}
			}
		}
			System.out.println((maxWidth*maxHeight - Width*Height)*K);
		}
	}
}