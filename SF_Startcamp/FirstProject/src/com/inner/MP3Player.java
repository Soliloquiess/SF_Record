package com.inner;

abstract class Movie{
	abstract void play();
}

interface Game
{
	void play(); //public abstract
}

class MyMovie extends Movie	//�߻� Ŭ���� �ڽ� ���� ���.
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
		//���� Ŭ���� : Ŭ���� ����� ������ ���ÿ� �����ϴ� Ŭ����.
		player.start(new MyMovie(){ //MovieŬ������ ��ӹ޴� �ڽ��� ������ �� �������� ��.
			@Override
			void play() {
				System.out.println("harry potter");
			}//Movie Ŭ������ ��ӹ޴� �ڽ��� ���b�� �� �������� ��.
		});
		player.start(new Movie() {
			
			@Override
			void play() {
				System.out.println("superman");
			}
		});
		
		player.start(new Game()	//�����̶� �������̽� ��ӹ޴� �ڽ� ����.

		//�ڽ��� �θ� �޼��� ������ �ҋ� ���ų� �аų� �Ҷ��� ����.
		//����Ŭ������ �θ𺸴� �аų� ���ų� �ؾߵǼ� public �ٿ���� �Ѵ�.
		{
			public void play() {
				System.out.println("Harry Potter");
			}
		});
	}
}
