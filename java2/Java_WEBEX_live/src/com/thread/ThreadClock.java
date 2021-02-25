package com.thread;

import java.util.Date;

public class ThreadClock implements Runnable {
	
	ThreadClock(){
		Thread t  =  new Thread(this);
		t.start();
	}
	
	public static void main(String[] args) {
		new ThreadClock();
	}
	
	//thread 작업내용. 1초간격으로 화면에 시간 출력하기
	@Override 
	public void run() {
		while(true) {
			Date d = new Date();//시간 하는거 가장 간단한게 date 객체 만드는 거
			//년월일 시분초요일
			System.out.println(d);	//쓰레드 한번 했으면 종료.(die)
			try {
				Thread.sleep(1000); //1초 자러감/
			} catch (InterruptedException e) {	

				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
}