package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
/*
 * 1행으로 탑들의 높이를 입력받는다
 * 각 탑의 왼쪽으로 신호를 보낸다.
 * 왼쪽의 타워가 더 높은 경우 그 타워의 인덱스를 출력한다.
 */

class Tower {
	public int index;             //타워의 인덱스
	public int height;            //타워의 높이
	public int target;            //이 타워의 레이저를 수신하는 타워위치

	public Tower(int index, int height) {
		this.index = index;
		this.height = height;
		this.target = 0; //0으로 초기화
	}

	void setTarget(int target) {
		this.target = target; //타겟 타워를 지정
	}

	int getTarget() {
		return this.target;             //타겟 타워를 반환
	}
}


public class Baek_2493_top {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		ArrayList<Tower> tower = new ArrayList<Tower>();  //탑 높이를 저장할 배열
		
		
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		for(int i = 0;i < N; i++) {
			int height = Integer.parseInt(st.nextToken()); //탑 높이 입력받음
			
			tower.add(new Tower(i+1, height)); //타워의 인덱스. 그대로 출력하기위해 인덱스에+1, 높이를 매개변수로 준다
		}
		
		Stack<Tower> stack = new Stack<Tower>(); //현제의 건물이 신호를 받을만한 건물들을 스택으로 쌓아놓는다.
		
		for(int i = 0; i < tower.size(); i++) {
			Tower t = tower.get(i);
			int target = 0;
			while(!stack.isEmpty() && stack.peek().height < t.height) { //스택이 빈경우 | 스택에 있는 건물의 높이보다 지금 높이가 큰 경우: 신호가 만나지 않는다
				stack.pop();               //신호가 만나지 않으므로 스택에서 제거한다.
			}
			
			if(stack.size() > 0) {         //만약 스택이 비어있지 않다면
				target = stack.peek().index; //스택의 가장 높은 위치의 인덱스를 현재 타워클래스의 인덱스에 저장
			}
			t.setTarget(target);   //if문에 걸렸다면 해당 타워의 인덱스를, 스택이 비었으면 인덱스는 0으로 저장
			stack.push(t);                 //현재타워는 비교하지않았으므로 스택 맨위로 저장
		}
		
		for(int i = 0; i < N; i++) {
			Tower t = tower.get(i);
			StringBuilder sb = new StringBuilder();
			sb.append(t.getTarget()).append(" ");
			System.out.print(sb);
		}
	}//main
}


