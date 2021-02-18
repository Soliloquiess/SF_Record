package SWEA;

import java.util.*;
import java.io.*;
import java.util.*;

public class SWEA_1961_���ڹ迭ȸ�� {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			StringTokenizer st;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
            //������ �迭�� 90�� ȸ��
			int[][] arr90 = rotate(arr);
            
            //90�� ȸ���� �迭�� �ٽ� 90�� ȸ�� == 180�� ȸ��
			int[][] arr180 = rotate(arr90);
            
            //180�� ȸ���� �迭�� �ٽ� 90�� ȸ�� == 270�� ȸ��
			int[][] arr270 = rotate(arr180);
						
                        
			System.out.println("#"+tc);
			for(int i=0; i<N; i++) {
            
            	//90�� ȸ�� �迭 ���
				for(int j=0; j<N; j++) {
					System.out.print(arr90[i][j]);
				}
				System.out.print(" ");
                
                //180�� ȸ�� �迭 ���
				for(int j=0; j<N; j++) {
					System.out.print(arr180[i][j]);
				}
				System.out.print(" ");
                
                //270�� ȸ�� �迭 ���
				for(int j=0; j<N; j++) {
					System.out.print(arr270[i][j]);
				}
				System.out.println();
			}
		}

	}
	
	
	//90�� ȸ����Ű�� �Լ�
	static int[][] rotate(int[][] arr) {
    
		int[][] newarr = new int[N][N]; //���ο� �迭���� ȸ���� ���� �־��ش�.
		int k = 0; //���� �迭�� ���� ����Ű�� index
        
		for(int j=N-1; j>=0; j--) {
			for(int i=0; i<N; i++) {
            	//���ο� �迭���� ������ ��(N-1)����, �� �������� ù ��(0)���� ä���ش�.
                //���� �迭�� k�� i������ �־��ش�. (0��0������ ������� �־��ش�)
				newarr[i][j] = arr[k][i];
			}
			k++;
		}
		
		return newarr;
	}

}
//public class SWEA_1961_���ڹ迭ȸ�� {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int test = sc.nextInt();
//		for(int t = 1; t <= test; t++) {
//			int n = sc.nextInt();
//			int[][] a = new int[n][n];
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < n; j++) {
//					a[i][j] = sc.nextInt();
//				}
//			}
//			System.out.println("#" + t + " ");
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < n; j++) {
//					System.out.print(a[n-j-1][i]);
//				}
//				System.out.print(" ");
//				for(int j = 0; j < n; j++) {
//					System.out.print(a[n-i-1][n-j-1]);
//				}
//				System.out.print(" ");
//				for(int j = 0; j < n; j++) {
//					System.out.print(a[j][n-1-i]);
//				}
//				System.out.println();
//			}
//		}
//	}
//}