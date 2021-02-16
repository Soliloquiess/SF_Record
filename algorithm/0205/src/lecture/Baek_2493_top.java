package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
/*
 * 1������ ž���� ���̸� �Է¹޴´�
 * �� ž�� �������� ��ȣ�� ������.
 * ������ Ÿ���� �� ���� ��� �� Ÿ���� �ε����� ����Ѵ�.
 */

class Tower {
	public int index;             //Ÿ���� �ε���
	public int height;            //Ÿ���� ����
	public int target;            //�� Ÿ���� �������� �����ϴ� Ÿ����ġ

	public Tower(int index, int height) {
		this.index = index;
		this.height = height;
		this.target = 0; //0���� �ʱ�ȭ
	}

	void setTarget(int target) {
		this.target = target; //Ÿ�� Ÿ���� ����
	}

	int getTarget() {
		return this.target;             //Ÿ�� Ÿ���� ��ȯ
	}
}


public class Baek_2493_top {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		ArrayList<Tower> tower = new ArrayList<Tower>();  //ž ���̸� ������ �迭
		
		
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		for(int i = 0;i < N; i++) {
			int height = Integer.parseInt(st.nextToken()); //ž ���� �Է¹���
			
			tower.add(new Tower(i+1, height)); //Ÿ���� �ε���. �״�� ����ϱ����� �ε�����+1, ���̸� �Ű������� �ش�
		}
		
		Stack<Tower> stack = new Stack<Tower>(); //������ �ǹ��� ��ȣ�� �������� �ǹ����� �������� �׾Ƴ��´�.
		
		for(int i = 0; i < tower.size(); i++) {
			Tower t = tower.get(i);
			int target = 0;
			while(!stack.isEmpty() && stack.peek().height < t.height) { //������ ���� | ���ÿ� �ִ� �ǹ��� ���̺��� ���� ���̰� ū ���: ��ȣ�� ������ �ʴ´�
				stack.pop();               //��ȣ�� ������ �����Ƿ� ���ÿ��� �����Ѵ�.
			}
			
			if(stack.size() > 0) {         //���� ������ ������� �ʴٸ�
				target = stack.peek().index; //������ ���� ���� ��ġ�� �ε����� ���� Ÿ��Ŭ������ �ε����� ����
			}
			t.setTarget(target);   //if���� �ɷȴٸ� �ش� Ÿ���� �ε�����, ������ ������� �ε����� 0���� ����
			stack.push(t);                 //����Ÿ���� �������ʾ����Ƿ� ���� ������ ����
		}
		
		for(int i = 0; i < N; i++) {
			Tower t = tower.get(i);
			StringBuilder sb = new StringBuilder();
			sb.append(t.getTarget()).append(" ");
			System.out.print(sb);
		}
	}//main
}


