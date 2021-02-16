package live;

import java.util.Scanner;

public class S2_BinaryCountingTest {
	static int N;
	static int[] input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		for(int i =0; i<N;i++) {
			input[i] = sc.nextInt();
		}
		generateSubset(1<<N);
	}
	
	private static void generateSubset(int caseCount) {
		for(int flag =0; flag<caseCount; flag++) {	//i:��Ʈ����ũ �Ǿ��ִ� ��
			for(int j = 0; j<N; j++) {//�� �ں���N���� ��Ʈ���� Ȯ��
				if((flag & 1<<j)!=0) {
					System.out.print(input[j]+" ");
				}else {
					System.out.print("X ");
				}
			}
			System.out.println();
		}
	}
}
