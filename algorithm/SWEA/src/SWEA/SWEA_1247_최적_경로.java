package SWEA;


import java.util.*;
//
//public class SWEA_1247_����_��� {
//	static int N;
//	static int Min;
//	
//	public static void Perm(int num,int[][] map, int[] result, boolean[] check) {
//		//������
//		if(num==N+1) {
//			int sum = 0;
//			//�ּ� �Ÿ��� �� ���
//			for(int i=0;i<N+1;i++) {
//				sum += Math.abs(map[result[i]][0]-map[result[i+1]][0]) + Math.abs(map[result[i]][1]-map[result[i+1]][1]);
//			}
//			
//			//����ġ��->����ð� ���� �� ����.
//			if(sum<Min) Min = sum;
//			return;
//		}
//		
//		//���� 0�� �湮���� üũ
//		result[0] = 0;
//		check[0] = true;
//		
//		//ȸ�縦 N+1�� �湮���� üũ
//		result[N+1] = N+1;
//		check[N+1] = true;
//		
//		
//		//���� ����
//		for(int i=1;i<N+1;i++) {
//			if(check[i]) continue;
//			result[num] = i;
//			check[i] = true;
//			Perm(num+1,map,result,check);
//			check[i] = false;
//		}
//	}
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();//�׽�Ʈ���̽� ���� �Է�
//		
//		for(int tc=1;tc<=T;tc++) {
//			N = sc.nextInt();//���� ��
//			
//			int[][] map = new int[N+2][2]; //��ǥ����迭
//			boolean[] check = new boolean[N+2]; //�湮 üũ
//			int[] result = new int[N+2]; //�̴� ���
//			
//			//�ּ�
//			Min = Integer.MAX_VALUE;
//			
//			//����ǥ
//			map[0][0] = sc.nextInt();
//			map[0][1] = sc.nextInt();
//			
//			//ȸ����ǥ
//			map[N+1][0] = sc.nextInt();
//			map[N+1][1] = sc.nextInt();
//			
//			//���� ��ǥ �Է� �޾Ƽ� 1~N���� �Է�
//			for(int i=1;i<=N;i++) {
//				map[i][0] = sc.nextInt();
//				map[i][1] = sc.nextInt();
//			}
//			Perm(1,map,result,check);
//			System.out.printf("#%d %d\n",tc,Min);
//		}
//		
//	}
//	
//	
//}


import java.util.Scanner;

public class SWEA_1247_����_��� {
 
    static int N, min;
    static Point company;
    static Point home;
    static Point map[];
    static boolean visited[];
 
    static class Point {
        int r, c;
 
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
 
    static void dfs(int idx, Point current, int tmp) {
        if(min <= tmp)
            return;
         
        if (idx == N) {
            tmp += Math.abs(home.r - current.r) + Math.abs(home.c - current.c);
            min = Math.min(min, tmp);
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int dist = Math.abs(map[i].r - current.r) + Math.abs(map[i].c - current.c);
                dfs(idx + 1, map[i], tmp + dist);
                visited[i] = false;
            }
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
        for (int tc = 1; tc <= 10; tc++) {
            N = sc.nextInt();
            company = new Point(sc.nextInt(), sc.nextInt());
            home = new Point(sc.nextInt(), sc.nextInt());
            min = Integer.MAX_VALUE;
            map = new Point[N];
            visited = new boolean[N];
 
            for (int i = 0; i < N; i++) {
                map[i] = new Point(sc.nextInt(), sc.nextInt());
            }
 
            dfs(0, company, 0);
            System.out.println("#" + tc + " " + min);
        }
    }
}