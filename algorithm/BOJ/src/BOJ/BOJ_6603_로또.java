package BOJ;

//
//
import java.util.Scanner;

public class BOJ_6603_�ζ� {

	static int[] arr;
	static boolean[] visit;
	static int N;

	public static void dfs(int start, int depth) {
		if(depth == 6) {	// Ż�� ����(���)
			for(int i=0; i<N; i++) {
				if(visit[i] == true) {	// Ž���Ȱ� => ���
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
                        return;	// ��� �Լ� ����

		}
		
		for(int i=start; i<N; i++) {
			visit[i] = true;	// �湮�� �� üũ
			dfs(i+1, depth+1);	// ���ȣ��, �ϳ��� ���̸� Ž�� �� => ���� ȣ��� ����+1
			visit[i] = false;	// �ʱ�ȭ
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			N = scan.nextInt();
			arr = new int[N];
			visit = new boolean[N];
			
			if(N == 0)
				break;
			
			for(int i=0; i<N; i++) {
				arr[i] = scan.nextInt();
			}
			
			dfs(0, 0);
			System.out.println();
		}
		
		scan.close();
	}

}

//public class BOJ_6603_�ζ� {
//
//}
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class BOJ_6603_�ζ� {
//	
//	//static�� �̿��� ���� ������ �����.
//	static int k;
//	static int[] arr;
//	static boolean[] skip; //��ŵ �Ǻ�
//	
//	static void dfs(int line,int count) {
//		
//		if(count == 6) {
//			for(int i = 0; i < k; i++) {
//				if(skip[i] == true)
//					System.out.print(arr[i] + " ");
//			}
//			System.out.println("");
//		}
//		
//		for(int j = line; j < k; j++) {
//			skip[j] = true;
//			dfs(j+1, count+1); //���ȣ��
//			skip[j] = false; //���ȣ�� ������ �ش� �迭�� Ž�������Ѵ�.
//		}
//	}
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		while(true) {
//			k = sc.nextInt(); //���� ����, 6~13���� ��
//			if(k == 0) //0�Է½� ����
//				break;
//			
//			arr = new int[k]; //������ŭ �迭 ����
//			skip = new boolean[k]; //��Ʈ��ŷ
//			
//			for(int i = 0; i < arr.length; i++) { //�迭 �Է�
//				arr[i] = sc.nextInt();
//			}
//			Arrays.sort(arr);
//			
//			dfs(0,0);
//			System.out.println();
//		}
//		sc.close();
//	}
//}