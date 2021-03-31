package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _62_병합정렬 {
static	int[] a= new int[101];
static	int[]tmp =new int[101];	
	
	public static void divide(int lt, int rt) {
		int mid;
		int p1, p2, p3;
		if (lt < rt) {
			mid = (lt + rt) / 2;
			divide(lt, mid);
			divide(mid + 1, rt);
			p1 = lt;
			p2 = mid + 1;	//시작점은 mid+1
			p3 = lt;
			while (p1 <= mid && p2 <= rt) {
				if (a[p1] < a[p2]) tmp[p3++] = a[p1++];
				//p3에 넣고 들어감.
				else tmp[p3++] = a[p2++];
			}
			while (p1 <= mid) tmp[p3++] = a[p1++];
			while (p2 <= rt) tmp[p3++] = a[p2++];

			//for문이 복사해 주는 코드
			for (int i = lt; i <= rt; i++) {
				a[i] = tmp[i];
			}
		}
	}
		public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st; 
			Scanner sc= new Scanner(System.in);
			st = new StringTokenizer(br.readLine()," ");
			
			int n, i;
//			scanf("%d", &n);
			n=  Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			
			for (i = 1; i <= n; i++) {
//				scanf("%d", &a[i]);
				a[i] = Integer.parseInt(st.nextToken());

			}
			divide(1, n);
			for (i = 1; i <= n; i++) {
				System.out.printf("%d ", a[i]);
			}
		}
}


