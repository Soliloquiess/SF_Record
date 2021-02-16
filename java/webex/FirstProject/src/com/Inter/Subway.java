package com.Inter;

public class Subway {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Sandwich[] s = new Sandwich[3];
		s[0] = new EggMayo();
		s[1] = new Shrimp();
		s[2] = new EggMayo();
		
		for(int i =0; i<3;i++)
		{
			System.out.println(s[i].getClass().getName());
			System.out.println(s[i].getDescription());
			System.out.println(s[i].getIngredient());
			System.out.println();
		}
		
	}

}
