package com.inherit;

class X
{
	void print() 
	{
		System.out.println("x-print");
	}
	void play()
	{
		System.out.println("y-play");
	}
}

class Y extends X
{
	void play() 
	{
		System.out.println("y-play");
	}
}
public class Z extends Y{
	void print() {System.out.println("z-print")};
	void play() {System.out.println("z-play")};
	
	}

}
