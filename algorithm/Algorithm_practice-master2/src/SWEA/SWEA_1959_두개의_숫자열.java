package SWEA;
//
//public class SWEA_1959_�ΰ���_���ڿ� {
//
//}
import java.io.*;
import java.util.*;

public class SWEA_1959_�ΰ���_���ڿ� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		

		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] a = new int[N];
			int[] b = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				b[j] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			int tmp = 0;
			if(N < M) {
				
				for(int j=0; j<=M-N; j++) { //�ε����� M-N�� �Ѿ�� ���� ����(N��)�� �Ѿ�Ƿ�
					int k=j; //���� ��ġ
					int sum = 0;
					for(int i=0; i<N; i++) { //N����ŭ���� a�迭�� b�迭�� ���� �����ش�.
						tmp = a[i] * b[k++]; //a�迭���� b�迭�� �����ֱ�
						sum += tmp; //���� ���� ��� �����ش�.
					}
					if(sum > max) max = sum; //�ִ��� ����
				}

			} else if(N == M) { //ũ�Ⱑ ���� ��쿡 �ִ��� ���� �Ѱ���.
				for(int i=0; i<N; i++) {
					max += a[i]*b[i];
				}
			} else { // N�� �� ū ���. M�� �� ū ���� �ݴ�� ���ָ� �ȴ�.
				for(int j=0; j<=N-M; j++) {
					int k=j;
					int sum = 0;
					for(int i=0; i<M; i++) {
						tmp = a[k++] * b[i];
						sum += tmp;
					}
					if(sum > max) max = sum;
				}
			}
			
			System.out.println("#"+tc+" "+max);
		}
	}

}