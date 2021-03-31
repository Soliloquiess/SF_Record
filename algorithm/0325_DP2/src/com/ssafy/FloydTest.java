package com.ssafy;

import java.util.Scanner;

/*
 * ��� ���� ���� �ּ� ���
 * ������ ���,
 * for 3�� ���
 * for - ������
 * 		for - �����
 * 			for - ������
 */
public class FloydTest {
		static final int INF =999;
		static int N, adjMatrix[][];
		static String src= "5\r\n"+
				
				"0 4 2 5 0\r\n"+
				"0 0 1 0 4\r\n"+
				"1 3 0 1 2\r\n"+
				"-2 0 0 0 2\r\n"+
				"0 -3 3 1 0";
	

	
	public static void main(String[] args) {
		Scanner sc = new Scanner (src);
		N = sc.nextInt();
		adjMatrix = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j =0; j<N;j++) {
				adjMatrix[i][j] = sc.nextInt();
				
				if(i!=j && adjMatrix[i][j] ==0) {	//������ ���� ���� ���
					//i�� j�� ���� �ʰ� i����j�� ���� ���� 0�̸� ���� �� ����.(i�� j�� ������ �ڱ��ڽ����� ���°�)
					//�ڱ��ڽ����� ���� ������ �ƴѵ� �� ���� 0�̶�� ���� ���������� �ʴ�.
					adjMatrix[i][j]= INF;//������ �־ �ּҺ���� 0�̵Ǵ� ��쵵 �ֱ⿡ �ٸ� ���� �־����.
				}
			}
				
		}
		System.out.println("�Է°�");
		print();
		
		//�ּҺ�� ����Ϸ� ��.(�÷��̵�� ���� 3���� ������ ��)
		for(int via =0; via<N; via++) {	//������
			for(int from = 0; from<N; from++) {	//�����(���Ⱑ ���� ��� �ٲ��)
				if(via == from) continue;
				for(int to=0; to<args.length; to++) {	//������
					if(from == to || via == to)	//3���� �� �Ȱ��� ��쵵 �ǹ̰� ����.
					{	continue;
				
					}
					if(adjMatrix[from][to] > adjMatrix[from][via] + adjMatrix[via][to]) {//from���� to�� ���� ���.
	//					from���� to�� ���� ����� ���ΰ�. �� ó���̸� ���̷�Ʈ�� ���� ����� �� ũ��.
						adjMatrix[from][to] = adjMatrix[from][via] + adjMatrix[via][to];
					}
				}
			}
			print();
		}
	}
	private static void print() {
		for(int i =0; i<N; i++) {
			for(int j =0; j<N; j++) {
				System.out.print(adjMatrix[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("----------");
	}
}

// 0���� �����°� �ڱ� �ڽ����� ���� ��.


// �� ó���� �ʱ����(�Է°� ���� �״��)
// ������ �����ϰ� ����� �����ϰ� ����


// ó������ �ʱⰪ�� 999���� �� �� ���� ��. �ѹ� ������ �����ϰ� ������ ��ģ���� ���ϱ� ���� ����(����� 0)

// ����� �ٲٰ� �������� �ٲ㰡�� ������ �ܰ躰�� Ȯ��.

//�������� ������ �� ����ϰ� ��� �������� ��� ����� �� ���. �� �������� �� �׽�Ʈ �Ѵ�.

//�Է� ���� ������ ������ �׸��׸��� �׽�Ʈ �غ���.
//������ �־ ������. �ٸ� ����Ŭ�� ������ �ȵȴ�.