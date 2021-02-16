package com.Inter;

public class EggMayo implements Sandwich{

	@Override
	public int getCalorie() {
		return 480;
	}

	@Override
	public String getIngredient() {
		return "에그마요 2수쿱, 치즈2장, 랜치, 스위트 칠리";
	}

	@Override
	public String getDescription() {
		return "친환경 인증 받은 농장에서 생산된 달걀과 고소한 마요네즈가 만나 더 부드러운 스테디셀러\r\n" + 
				"\r\n" 
				;
	}

	
	
}
