package live;

import java.util.Scanner;

public class C2_NextPermutationTest {

	static int N,R;
	static int[] input;
	static int[] P;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		R= sc.nextInt();
		
		input= new int[N];
		P = new int[N]; //Nũ���� flag�迭
		
		for(int i = 0; i<N;i++) {
			input[i] = sc.nextInt();
		}
		int cnt = 0;
		while(++cnt<=R) P[N-cnt] =1 ;
		do {
			for(int i = 0; i<N; i++) {
				if(P[i]==1) System.out.print(input[i]+" ");
			}
			System.out.println();
		}while(np(P));
	}
	
	private static boolean np(int[] arr) {
		
		//Step 1
		int i = N-1;
		while(i>0&&input[i-1]>=input[i]) --i;
			//������ġ�� ���� �༮�� ���纸�� ���ų� ū ����̸� �ö󰡴� ���
			//-1�ΰ� �����ϱ� �� �տ� ���� ������ ������ ���� �׷���i�� 0���� ũ�� �ؾߵ�.
		//���̻� �� �ڸ��� ���� ��Ȳ : �� ������ ���°� ���� ū ������ ����(������ ������ ����)
		if(i==0) return false;
		
		//Step2
		int j = N-1;
		while(input[i-1]>=input[j]) --j;
		
		//Step3
		swap(arr,i-1,j);
		
		//Step4
		int k = N-1;
		while(i<k) {
			swap(arr,i++,k--);
		}
		return true;
	}
	
	private static void swap(int[] arr, int i, int j)
	{
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

}


