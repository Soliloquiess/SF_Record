package SWEA;


import java.io.*;
import java.util.*;

public class SWEA_6808_규영이와_인영이의_카드게임 {
	static boolean[] numeric = new boolean[19];
	static boolean[] ck;
	static int[] bd1 = new int[9];
	static int[] bd2 = new int[9];
	static int ans,cnt,mucnt;
	static void permu(int r,int sum1, int sum2) {
		if(r==9) { //9라운드가 지나고, 값 비교를 통해 
			cnt++; //모든 가지수 
			if(sum1 > sum2) ans++; //이긴 가지수
			if(sum1 == sum2) mucnt++; //비긴 가지수 증가
			return;
		}
		for(int i=0; i<9; i++) { // 한 라운드당 9개의 숫자 중, 이전 라운드에서 선택이 안된 숫자를 선택.
			if(!ck[i]) {
				ck[i]=true;
				if(bd1[r]>bd2[i]) {
					permu(r+1,sum1+bd1[r]+bd2[i],sum2); //bd1의 숫자가 클 경우, sum1에 값을 더해준다.
				}else {
					permu(r+1,sum1,sum2+bd1[r]+bd2[i]); //bd2의 숫자가 클 경우, sum2에 값을 더해준다.
				}
				ck[i]=false;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			ans = cnt = mucnt = 0;
			ck = new boolean[9];
			numeric = new boolean[19];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) {
				bd1[i]=Integer.parseInt(st.nextToken());
				numeric[bd1[i]]=true; //규영이가 선택한 카드는 true로 체크
			}
			int tmp=0;
			for(int i=1; i<=18; i++) {
				if(!numeric[i]) //카드가 체크가 안되어있는 경우, bd2에 카드 숫자 넣는다.
					bd2[tmp++]=i;
			}
			permu(0,0,0);
			sb.append("#"+t+" "+ans+" "+(cnt-ans-mucnt)+"\n"); //ans는 이긴가지수,
            //cnt-ans-mucnt 는 전체가지수에서 이긴가지수와 비긴가지수 뺀 가지수.
		}
		System.out.println(sb.toString());
	}	
}


/*

import java.io.*;
import java.util.*;

public class Solution {
	static boolean[] numeric = new boolean[19];
	static boolean[] ck;
	static int[] bd1 = new int[9];
	static int[] bd2 = new int[9];
	static int win,lose;
	static void permu(int r,int sum1, int sum2) {
		if(sum1 > (171/2) || sum2 > (171/2)) { //둘 중 하나라도 기준점을 넘어가면,
			int oth = 1;
			for(int tmp = 9-r; tmp>0; tmp--) {
				oth *=tmp; //나머지 라운드에 대해 팩토리얼 계산만 한다.
			}
            //이기고 있는 쪽에 oth 를 더해준다.
			if(sum1 > sum2) win+= oth; 
			else lose+= oth;
			return;
		}
		for(int i=0; i<9; i++) {
			if(!ck[i]) {
				ck[i]=true;
				if(bd1[r]>bd2[i]) {
					permu(r+1,sum1+bd1[r]+bd2[i],sum2);
				}else {
					permu(r+1,sum1,sum2+bd1[r]+bd2[i]);
				}
				ck[i]=false;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			win = lose = 0;
			ck = new boolean[9];
			numeric = new boolean[19];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) {
				bd1[i]=Integer.parseInt(st.nextToken());
				numeric[bd1[i]]=true;
			}
			int tmp=0;
			for(int i=1; i<=18; i++) {
				if(!numeric[i])
					bd2[tmp++]=i;
			}
			permu(0,0,0);
			sb.append("#"+t+" "+win+" "+lose+"\n");
		}
		System.out.println(sb.toString());
	}	
}


*/