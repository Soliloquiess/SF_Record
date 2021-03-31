package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST1_KruskalTest {
	
	static class Edge implements Comparable<Edge>{
		int from , to, weight;
		//���� �����ΰ� �ٸ� ������ �ڱ� ������ ��(������ ��븦 �A��)
//		�׻� ���� �������� ��븦 ���� ����(���� �����̸� ������ �������. )

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
//			return this.weight -o.weight;
			return Integer.compare(this.weight, o.weight);
//			���� ���� ������ ���ϰ� ���� �����ϸ� Integer.comapre�̿��ؼ� ���� �߻��ϸ� ����÷� ����� ���� ������ �����÷ο� �߻��ϴϱ�
//			���������� �̷��� �ᵵ �� . �˾Ƽ� ���������� �տ��� �ڸ� �M(��ȣ�� ũ��˻��ؼ� �˾Ƽ� ��.)
		}
		
		
		
	}
	
	static int V,E;	//��Ʈ ����Ʈ R Ű������ ������(rename), V�� ���� ����, E�� ���� ����.
	static int parents[];
	static Edge[] edgeList; //���� ����Ʈ ���� ��(���� ���� �ٰŶ� �迭�� ����.
	//���� ���� �𸣸� ��̸���Ʈ ���� ������ ���� ������ ���� �˸� �迭 �� �� ������ �����ϱ� �迭�� �ᵵ �ȴ�.
	static void make() {	// ũ�Ⱑ 1�� ���������� �����.
		for(int i =0; i<V; i++) {
			parents[i] = i;	//�ڱ� �迭 ��ġ�� �ڱ� �� ����.	�ڱ� �ڽ��� ��ǥ��
		}
	}
	
	//2. ��ǥ�ڸ� ã�� �޼���
	static int findSet(int a) {	//find�� ���� ������ ��ǥ�ڸ� ã����(����ϸ鼭 �Ķ���Ͱ� a���µ� a�� �θ� ����־
		//a�� �θ��� �θ� ã�ư��鼭 ��� ���� �������� ���� ���� �����ؼ� ã�� a���� ����.
		if(parents[a]==a) return a;	//������ǥ�� �׳� ����.	�ڱ��ڽŰ� ������ �ڱⰡ ��ǥ�ڶ� �ٷθ���
		//�θ𿡵� �θ� ���� �� �ְ� ��� �ö�.
//		return findSet(parents[a]);		//path Compression ��
		return parents[a] =  findSet(parents[a]);		//path Compression ��
		//�ƴϸ� �ٸ� ���� ����־����� �� ���� �ö󰡼� ��ǥ�� ã�� ��.
		//ã�� �θ��� a�� �θ����� �ٽ� �������.
		//�ö󰡼� ã�� ��ǥ���� ����.
	}
	
	static boolean union(int a, int b) {	//���Ͽ��� ���ϰ��� �� �ʿ����� ������ �� ���������� Ȯ���ؾ� �� ������ �ִ�.
		//�ƿ� ���ϰ� Ȱ���ϰ� ���°� �ξ� ������ ����.
		//���ʿ� �ִ� a�� ���ʿ� �ִ� b�� �ִ´�.
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		//����� �Ű������θ� ���� ¯ ���� ��ġ�� ��.
		if(aRoot == bRoot) {	//�� ������ ¯�� ���� ��Ȳ�̸� �̹� ���� �����̹Ƿ� ��ĥ �ʿ䰡 ����.
			return false;	//��ġ�� ���� ��� ����.
		}
		
		parents[bRoot] = aRoot;	//aRoot�� �� ������ b�� �ִ°� �ƴ϶� b�Ǻθ� �����ؼ� ��ǥ�ڿ� ��ǥ�ڳ��� �۾��ϰ� ��.
		//b�� ��ǥ�� �������.
		//�̰� �� ����ϸ� ���� Ǯ�� �����ϱ� ����.
		//b��Ʈ�� �θ� a��Ʈ�� �ٲ���.
		return true;
		//���߿� ��ũ �̿��ϸ� ��ũ ���ؼ� ��ũ�� ���� �ʿ� ���� �� ���̰� ���� ��ũ ������ �ڽ��� ��ũ �ϳ� �÷��ִ� �̷� �ڵ尡 �ʿ�
		//path ���������� ��ũ ���� ��������.
	}
	
	//������� ���μ� ���� �����ϴ� �κ�.
	
	public static void main(String[] args) throws IOException {
		//���ο��� �ּҽ���Ʈ�� ����� ���� ���Ͽ� Ȱ�븸 �ϸ� ��.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parents = new int [V];	//�������� �迭
		edgeList = new Edge[E];	//���� ���� �迭
	
		for(int i =0; i<E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}	//���� ����Ʈ
	
		//1. ���� ����Ʈ ����ġ ���� �������� ����
		Arrays.sort(edgeList);	//(�̹� ������ �������� �����ؼ� ȣ�⸸ �ϸ� ��)
		
		//���⼭ ���� ���Ͽ� ���ε� �۾�
		make();
		int result = 0; //����ġ�� �� ���� ����
		int count = 0; // ������ ���� ��(� �����ߴ��� ī��Ʈ �ؾߵ�
		
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {	// �� ����� true�� ����Ŭ�� �߻����� �ʾҴٸ� ���� �ٸ�����.
				result += edge.weight;
				if(++count ==V-1) break;	//���� -1 ������ �Ǹ� �� �� �ʿ䰡 ����
				
			}
		}
//		������ union�Ǹ� �� �� ��� ���� ��Ű�� ī��Ʈ �ø��� ī��Ʈ�� ����-1������ �Ǹ� ��������
//		���� �׶����� ������ result�� ������ �ȴ�.
		System.out.println(result);
	}
	
}
