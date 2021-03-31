package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST2_PrimTest2 {
	
	public static void main(String[] args) throws IOException {
		//���ο��� �ּҽ���Ʈ�� ����� ���� ���Ͽ� Ȱ�븸 �ϸ� ��.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [][] adjMatrix = new int[N][N];
		boolean[] visited = new boolean[N];
		int [] minEdge = new int[N];
		StringTokenizer st = null;
		
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j =0; j<N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());	
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		int result = 0;
		minEdge[0] = 0;
		
		for(int c = 0; c<N; c++) {	
			
			int min  = Integer.MAX_VALUE;//�ּҰ� ã���Ŵϰ� ū ������ �ְ� ���.
			int minVertex =0;
			//����Ʈ���� ������� ���� ���� �� minEdge����� �ּ��� ����.
			for(int i =0; i<N;i++) {	//�ּ� ���� ��� ���� �� ã�ƾ�
				if(!visited[i] && min>minEdge[i]) {//�ش� ������ ���� ����Ʈ�� �������� �ʾҰ� �� ������ �ֵ� �� ����� �ֵ��� �� ������ ���� ���� �������� �����Ҽ� �ִ� �༮ ã�� 
					min = minEdge[i];
					minVertex = i;	//������ ����� �ּ��� ������ ���鼭 ��� ã��
					
				}
			}
			//�� ������ ����Ʈ�� ���� �ȵ� �ֵ��� ����Ʈ�� ����� ���� ���� �ְ� ����
			// �� ó������ 0���� ������ 0�� ������ ����
			//minvertex�� ����ġ ���� ���ġ�� �����ϰ� ����Ʈ���� ���ԵǴϱ� true�� �ٲ���
			result +=min;
			visited[minVertex] = true;
			
			for(int i =0; i<N; i++) {
				if(!visited[i] && adjMatrix[minVertex][i]!=0 && minEdge[i]>adjMatrix[minVertex][i]) {	//�������� �������� 0�� �ƴϾ�� �ǰ� �� �༮�� �ٸ� �������� �ڽ����� ���� ������ ����� minVertex���� i�� ���� ������ ��뺸�� ũ�ٸ�  minVertex���� i�� ���°� �� ����
					//minvertex���� i �� ���� ���� ��뺸�� �� ũ�ٸ� minvertx���� i�� ���°� �� ����
					minEdge[i] = adjMatrix[minVertex][i];
				//�ּ� ��������� �ٸ����� ���°ź��� ������ ���°� �� �����ϴٰ� ������ ����.
				//�ݺ� ���鼭 ���� �� ����� �� �ֵ��� �ڽ��� �� ������ ���� ���� ����� ������ �ٸ��ְ� ������������ �����ϸ� ������ �ݺ� ���� �ּҺ���� ���� ���õǰ� ����
			
				}

			}
		}

		System.out.println(result);
	}

}
