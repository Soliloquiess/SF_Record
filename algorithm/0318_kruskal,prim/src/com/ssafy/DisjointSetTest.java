package com.ssafy;

import java.util.Arrays;

public class DisjointSetTest {
	static int N;
	static int parents[];
	
	static void make() {	// ũ�Ⱑ 1�� ���������� �����.
		for(int i =0; i<N; i++) {
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
	
	public static void main(String[] args) {
		N=5; //���ǻ� ������ ���� 5��
		parents = new int[N];//���� ������ŭ �迭 ����
		
		//1.make set ��� ���ҵ�� ��ȣ��Ÿ���� ���� �����.
		make();

		System.out.println("=====union=====");
		System.out.println(union(0,1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(1,2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(3,4));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0,2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0,4));
		System.out.println(Arrays.toString(parents));
		
		System.out.println("=====find=====");
		
		System.out.println(findSet(4));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(3));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(2));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(0));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(1));
		System.out.println(Arrays.toString(parents));
		
	}
}
