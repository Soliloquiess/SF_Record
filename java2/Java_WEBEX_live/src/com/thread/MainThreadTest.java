package com.thread;

class Car{}
public class MainThreadTest implements Runnable{
	MainThreadTest(){// 생성자 
		// 생성해서 시작시키기
		Thread t = new Thread(this);	//사용자 쓰레드
		t.start();	//run()으로 감.
		try {
			t.join();	//** 순서가 중요하면 join으로 다른 일 하기 전 마치게 하고 실행하게**
			//**join 메서드는 쓰레드 간의 순서를 잡아준다.!**

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void go() {
		System.out.println("gogo");
	}
	
	public static void main(String[] args) {
		MainThreadTest m = new MainThreadTest();//생성자 호출 됨
		m.go();	//메인 메서드가 실행.
	}	
	@Override 
	public void run() { //thread 작업 내용
		System.out.println("run method....");
	}
}
