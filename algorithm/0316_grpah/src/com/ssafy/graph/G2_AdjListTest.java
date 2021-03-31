package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
*/

public class G2_AdjListTest {
	
	static class Node{
		
		int vertex;
		Node next;
		//���Ḯ��Ʈ�� ��� �ϳ��ϳ� ��Ÿ���� ����.
		//���� ��ȣ�� ���Ḯ��Ʈ �������� ��ũ�ǳ�� ������ ����.
		public Node(int vertex, Node next) {	//������ ����.(������)
			super();
			this.vertex = vertex;
			this.next = next;
			
		}
		public Node(int vertex) {		//���������� �ִ� ��� ����.
			super();
			this.vertex = vertex;
		}
		@Override
		public String toString() {	//�������̵�
			return "Node [vertex=" + vertex + ", next=" + next + "]";
		}
		
	}

	static int N;
	static Node[] adjList;	//��� �迭
	static boolean[] visited;
	//0�� ������ �� �������ִ�	���� �������� ���Ḯ��Ʈ�� ��(head)
	//������ ó���� �������� �� ��������. ����Ʈ ó���� �˸� ��ũ ���� �� ���� ��.
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		adjList = new Node[N];	//������ ������ŭ �迭 ����
		
		StringTokenizer st = null;
		for(int i =0; i<C;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to,adjList[from]);
			//0�� ��忡�� ������ ��� ���� ���� �� ������ ��� �ڿ� �ٿ���(0-2��)
			//0-3�̸� �Ȱ��� 2 ������ ���󰡼� ���δ�.
			//�׸��� �� �κе��� ����� ����.
			//from �� ������ ��带 ���� ���� ����� �ַ� �ٲ�� ��� ���� ����� �ְ� ù°�� �Ǳ� ���ؼ� ���� ��� ������ �ؽ�Ʈ�� �ξ �ڽ��� �ڷ� ���� �ϸ� ��� ù���� ���� ����ְ� �Ǵ� ��

			adjList[to] = new Node(from,adjList[to]);	//����� �ѹ� ���ؾ�
			//�̷��� �ϸ� ��������Ʈ ��. ����������ŭ �ϸ� ���� �� �۾����� ��� �ݺ��Ǹ� �� ��帶�� ������ �������� ���Ḯ��Ʈ ����� �� ��带 �� ���� �ְ� �ȴ�.
			
		}
		bfs();
		
		visited = new boolean[N];
		visited[0] = true;
		dfs(0);
	}
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean [] visited = new boolean[N];
		
		//Ž�� ���� ���� : 0���� ���
		int start =0;
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {	//ť�� ������� ���������� ���鼭
			int current = queue.poll();	//����(���� ���� ����)
			//���� ������ ���õ� ó��
			System.out.println((char)(current+65));	
			
			//���� ���� Ž��(���⼭ ���� �޶���)	
			//�Ʊ�� ��������̶� ����������ŭ �鿩�ٺ��� �ϳ��� üũ�ߴµ� �̹��� ��������Ʈ�� ������� ��������Ʈ�� ������ �ֵ鸸 ����֤���.
//			�׷��� �������� üũ �� �ʿ䰡 ����.
			for(Node temp = adjList[current]; temp!=null; temp = temp.next) {
				//Node temp = adjList[current]; �̰� ��������Ʈ�� ù���� �ص�
				
//for(Node temp = adjList[current]; temp!=null; temp = temp.next) { �� �κ��� ���� ������ �ݺ�ó��
//Ž���ϴ� ���� �ٲ�� �� bfs ���� �״����. �� �Ʒ��� ���� üũ ������ �ٲ��. ���ʿ��� ������ ������.
				
					if(!visited[temp.vertex]) {	//������ �Ǿ������� �������δ� �Ǵ��� �ʿ䰡 ����  ��尡 ����� ������ ���� �װ� � ���� �������� �� �� �ִ�. �װ� �湮�Ǿ����� �ƴ����� üũ
						queue.offer(temp.vertex);
						visited[temp.vertex] = true;
					}
					
				}
			}
		}
		
	private static void dfs(int current) {	//bfs�� ��� ť���� �̾Ƴ��� ������ dfs�� ��ʹ� ���� �޾ƿ��� �Ű����� ������ ��.
	
//		visited[current] = true;	�ƴϸ� ȣ����ڸ��� ����Ұų�.
		//������ �� �� �ϳ� ȣ���� ���� �� �ϳ� ���̰� ����. ������ ��ٷȴٴ°� �ƴ϶� visited�ϰ��ϳ� �ϰ� ���� ����
		
		System.out.println((char)(current+65));
		
		for(Node temp = adjList[current]; temp!= null; temp = temp.next) {
			if(!visited[temp.vertex]) {
				visited[current] = true;	//üũ�ϰ� �Լ�(�޼���)Ÿ�� ���ų� / �ƴϸ� ȣ����ڸ��� ����Ұų�.(������)
				//Ȥ�ó� �椱��üũ�ڵ� �Ʊ�ó�� ¥�������  �׻� ȣ���ϴ� �ڵ忡 ���� �ǰ� �־�����.
				//���� �ϴ��� �� ���ڸ��� ����(��� ���� ����)
				dfs(temp.vertex);
			}
		}
	}	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
