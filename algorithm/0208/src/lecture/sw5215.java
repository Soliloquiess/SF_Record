package lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw5215 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int test_case = 1; test_case<=T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); //�옱猷뚯닔
			int L = Integer.parseInt(st.nextToken()); //�젣�븳移쇰줈由�
			
			int[] calories = new int[N]; //移쇰줈由�
			int[] happy = new int[N]; //留쏇룊媛�
			int[][] dp = new int[N+1][L+1]; //媛��닔�� �늻�쟻移쇰줈由�
			//L+1�쓣 �븳 �씠�쑀�뒗 1000kcal�뒗 [1000]�쐞移섏뿉 ���옣�릺湲� �븣臾몄뿉 �븳移� �뜑 而ㅼ빞�븳�떎.
			//N+1�쓣 �븳 �씠�쑀�뒗 �븘臾닿쾬�룄 �븞戮묒� �긽�깭瑜� �몴�쁽�븯湲� �쐞�빐�꽌�떎.
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				happy[i] = Integer.parseInt(st.nextToken());
				calories[i] =Integer.parseInt(st.nextToken()); 
			}
			
			for(int i = N-1; i>=0; i--) {
				for(int j = 0; j <= L; j++) {//�젣�븳 移쇰줈由щ쭔�겮 諛섎났
					if(j < calories[i])
						dp[i][j] = dp[i+1][j];//�빐�떦 移쇰줈由щ낫�떎 �쟻�쑝硫� �씠 移쇰줈由щ�� 戮묒쓣 �닔 �뾾湲� �븣臾몄씠�떎.
					else
						//�빐�떦 移쇰줈由щ낫�떎 留롮쑝硫� �씠 �옱猷뚮�� �븞�꽔�� 留쏄낵 �씠 �옱猷뚮�� �꽔�뼱�꽌 留뚮뱾�뼱吏� 媛� 以� 媛��옣 �겙 媛믪쓣 戮묒쓣 �닔 �엳�떎.
						//洹� 以� 媛��옣 �겙媛믪쓣 �떟�쑝濡� �썝�븯誘�濡�, 鍮꾧탳�빐�꽌 媛��옣 �겙 嫄� �꽔�뒗�떎.
						dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j-calories[i]] +happy[i]);
				}
			}
			//�떎 戮묎퀬 理쒖쥌�쟻�씤 移쇰줈由ъ뿉 ���옣�맂 媛믪씠 媛��옣 �겙 媛믪씠�떎.
			System.out.println("#"+test_case+" "+dp[0][L]);
			
		}
		
	}
}
