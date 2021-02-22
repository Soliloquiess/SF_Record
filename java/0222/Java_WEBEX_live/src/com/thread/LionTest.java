package com.thread;

//2.Runnable interface 를 구현해서 thread 만드는 법
//3.Runnable 객체
class Lion implements Runnable{	//라이언은 쓰레드 종류인가  ㄴㄴ.
	
	//thread의 작업 내용이 들어있는 메서드
	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("thread is running..." + Thread.currentThread().getName());
	}
}

public class LionTest {
	public static void main(String[] args) {
		
		
		Lion l1 = new Lion(); //Thread는 아니지만 쓰레드가 해야할 작업 내용이 들어있는 run()은 가지고 있다.
		
		//l1.start();//l1이 쓰레드는 아니라 바로 이와 같은 건 안됨
		//스레드 자체는 아니여도 run이라는 메서드는 가지고 있어서 러너블 객체로 별도로 쓰레드를 만들면서 넣어주기 가능.
		
		
		Thread t1 = new Thread(l1);
		//Thread t2 = new Thread(new Tiger());	//이렇게도 가능. tiger의 run을 실행하러 간다.
		t1.start();//thread 의 작업시작을 알리는 메서드
		
//		대신 이렇게는 가능
//		t1이 쓰레드인데 여기에 l1을 넣어줌.
		
		
		
		Lion l2 = new Lion();
		Thread t2 = new Thread(l1);
		t2.start();
		
		Lion l3 = new Lion(); 
		Thread t3 = new Thread(l1);
		t3.start();
	
	}
}
