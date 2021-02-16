package SWEA;


import java.io.*;
import java.util.*;

public class SWEA_6808_�Կ��̿�_�ο�����_ī����� {
	static boolean[] numeric = new boolean[19];
	static boolean[] ck;
	static int[] bd1 = new int[9];
	static int[] bd2 = new int[9];
	static int ans,cnt,mucnt;
	static void permu(int r,int sum1, int sum2) {
		if(r==9) { //9���尡 ������, �� �񱳸� ���� 
			cnt++; //��� ������ 
			if(sum1 > sum2) ans++; //�̱� ������
			if(sum1 == sum2) mucnt++; //��� ������ ����
			return;
		}
		for(int i=0; i<9; i++) { // �� ����� 9���� ���� ��, ���� ���忡�� ������ �ȵ� ���ڸ� ����.
			if(!ck[i]) {
				ck[i]=true;
				if(bd1[r]>bd2[i]) {
					permu(r+1,sum1+bd1[r]+bd2[i],sum2); //bd1�� ���ڰ� Ŭ ���, sum1�� ���� �����ش�.
				}else {
					permu(r+1,sum1,sum2+bd1[r]+bd2[i]); //bd2�� ���ڰ� Ŭ ���, sum2�� ���� �����ش�.
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
				numeric[bd1[i]]=true; //�Կ��̰� ������ ī��� true�� üũ
			}
			int tmp=0;
			for(int i=1; i<=18; i++) {
				if(!numeric[i]) //ī�尡 üũ�� �ȵǾ��ִ� ���, bd2�� ī�� ���� �ִ´�.
					bd2[tmp++]=i;
			}
			permu(0,0,0);
			sb.append("#"+t+" "+ans+" "+(cnt-ans-mucnt)+"\n"); //ans�� �̱䰡����,
            //cnt-ans-mucnt �� ��ü���������� �̱䰡������ ��䰡���� �� ������.
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
		if(sum1 > (171/2) || sum2 > (171/2)) { //�� �� �ϳ��� �������� �Ѿ��,
			int oth = 1;
			for(int tmp = 9-r; tmp>0; tmp--) {
				oth *=tmp; //������ ���忡 ���� ���丮�� ��길 �Ѵ�.
			}
            //�̱�� �ִ� �ʿ� oth �� �����ش�.
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