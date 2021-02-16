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
		P = new int[N]; //N크기의 flag배열
		
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
			//현재위치의 앞쪽 녀석이 현재보다 같거나 큰 모습이면 올라가는 모습
			//-1인건 없으니까 내 앞에 누가 있을떄 까지만 가능 그래서i가 0보다 크긴 해야됨.
		//더이상 앞 자리가 없는 상황 : 현 순열의 상태가 가장 큰 순열의 상태(마지막 순열의 상태)
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


