package com.ssafy.sd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dijkstra {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		int start = 0; //�����
		int end = V-1;	//������.
		int [][] adjMatrix = new int[V][V];//�������
		
		StringTokenizer st = null;
		for(int i =0; i<V;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j  =0; j<V;j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int [] distance = new int[V];
		boolean [] visited = new boolean[V];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		for(int i =0; i<V;i++) {
			//step1. ó������ ���� ���� �� ������� ���� ����� ���� ����
			int min = Integer.MAX_VALUE;
			int current=0; //min�� �ּҺ�뿡 �ش��ϴ� ������ȣ.
			for(int j =0; j<V; j++) {
				if(!visited[j] && min > distance[j]) {
//					distance�� �� �� �ּ��� ���� ã�ƾ� �ϴϱ�.
					min = distance[j];
					current = j;	//current �� ���� ���� ����� ���� ������ ����.
				}
			}
			
			visited[current] = true;
			if(current== end)break; //���̸� �ٸ������� �����ؼ� ���ļ� ���� �ָ� ã�� �ʿ� ����.
			//��������� ������ ���� ��� ��� ���� �žƴϸ� ���⼭ ������ �ȴ�.
			//step2. ���õ� current�� �������� �Ͽ� ���� ó������ ���� �ٸ� �������� �ּҺ���� ��������.
			for(int j =0; j<V;j++) {
				if(!visited[j] && adjMatrix[current][j]!=0 && distance[j]>min+adjMatrix[current][j]) {
					//��������� current���� ���Ѱ� �ּҺ�� . ��������� j�� ���� ��뺸�� ũ�� ���� �ź��� ���ļ� ���°� �� �����ϴٴ� �ǹ̴ϱ�
					distance[j] = min+adjMatrix[current][j];
				}
				
			}
		}
		System.out.println(distance[end]);
		//���� ��������� � ������ ���� end ������ max_value
		//�׷��� �ʱⰪ�� maxvalue�� � ������ �ص� �������� ������.
	}
}
