package com.swing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTest {
	JFrame f; //창
	JButton ok,cancel;
	
	public static void main(String[] args) {
		new SwingTest().gui();
	}

	//화면구성
	private void gui() {
		// TODO Auto-generated method stub
		//1. 창 만들기
		f = new JFrame("스윙 테스트입니다.");
		//2.창닫기 버튼 클릭했을떄의 동작 지정(닫기 버튼 클릭 시 프로그램 종료) 이건 디폴트
		//막 얼럿창 마냥 물어보게 하려면 추가작업 필요.
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		//이 걸 안하면 닫기버튼 눌러도 종료가 안됨. 창만 사라지고 백그라운드에서 계속 돌고 있음.
		//창을 만들게 되면 내부에서 화면에 계속 내용을 뿌려줌.
		//자동 종료가 안 됨.
		
		//EXIT_ON_CLOSE 이 부분 클래스 이름으로 쓴거 보니까 스태틱 이름 같다.
		//close 버튼 눌렀을때 프로그램 종료해라.
		//3.배치 관리자 지정
		f.setLayout(new FlowLayout());	//오른쪽부터 붙어나감
		//4.화면 구성할 내용물 지정
		ok = new JButton("확인");
		cancel = new JButton("취소");
		//5.만든 내용물들을 화면에 붙이기
		Container c = f.getContentPane();
		c.add(ok);
		c.add(cancel);
		//6.창크기 지정 후 가시성 지정.
		f.setSize(300,300);
		f.setVisible(true);
		
		
		
	}
}
