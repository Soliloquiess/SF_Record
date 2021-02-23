package com.thread;


//1.쓰레드 클래스 상속 받아서 쓰레드 만드는 방법
class Tiger extends Thread{
	//run(): thread가 해야할 작업 내용을 가지고 있는 메서드
	//callback메서드 : 직접 호출되지 않고 간접적으로 호출됨.
	
	public void run() {
		System.out.println("thread is running..." + getName());
		
	}
}
public class TigerTest {
	public static void main(String[] args) {
		Tiger t1= new Tiger(); //Thread를 생성한 거임
		t1.start();// 스레드의 작업 시작을 알려주는 메서드.
		
		Tiger t2= new Tiger(); //Thread를 생성한 거임
		t1.start();// 스레드의 작업 시작을 알려주는 메서드.
		
		Tiger t3= new Tiger(); //Thread를 생성한 거임
		t1.start();// 스레드의 작업 시작을 알려주는 메서드.
	}
}
