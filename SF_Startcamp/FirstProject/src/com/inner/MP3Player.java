package com.inner;

abstract class Movie{
	abstract void play();
}

interface Game
{
	void play(); //public abstract
}

class MyMovie extends Movie	//추상 클래스 자식 만들어서 사용.
{
	@Override
	void play() {}
}


public class MP3Player {
	public void start(Movie m)
	{
		m.play();
	}
	
	public void start(Game g)
	{
		g.play();
	}
	
	public static void main(String[] args) {
		MP3Player player = new MP3Player();
		//무명 클래스 : 클래스 선언과 생성을 동시에 수행하는 클래스.
		player.start(new MyMovie(){ //Movie클래스를 상속받는 자식을 선언한 후 생성까지 함.
			@Override
			void play() {
				System.out.println("harry potter");
			}//Movie 클래스를 상속받는 자식을 선얺나 후 생성까지 함.
		});
		player.start(new Movie() {
			
			@Override
			void play() {
				System.out.println("superman");
			}
		});
		
		player.start(new Game()	//게임이란 인터페이스 상속받는 자식 만듬.

		//자식이 부모 메서드 재정의 할떄 같거나 넓거나 할때는 가능.
		//무명클래스가 부모보다 넓거나 같거나 해야되서 public 붙여줘야 한다.
		{
			public void play() {
				System.out.println("Harry Potter");
			}
		});
	}
}
