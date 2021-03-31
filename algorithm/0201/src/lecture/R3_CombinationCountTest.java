package lecture;

import java.util.Scanner;

public class R3_CombinationCountTest {

	// n媛� 以� k媛쒕�� 戮묐뒗 議고빀�쓽 寃쎌슦�쓽 �닔 由ы꽩 
	public static int combination(int n, int k){
		if(n==k || k == 0){
			return 1;
			
		}else
		// n-1踰덉㎏源뚯� k媛쒕�� �떎 戮묐뒗 寃쎌슦�쓽 �닔(n踰덉㎏�썝�냼 議고빀�뿉 �룷�븿�떆�궎吏� �븡�쓬)�� combination(n-1, k-1) 
		// n-1踰덉㎏源뚯� k-1媛쒕�� �떎 戮묐뒗 寃쎌슦�쓽�닔(n踰덉㎏�썝�냼 議고빀�뿉 �룷�븿�떆�궡)瑜� �뜑�븳�떎. combination(n-1, k)
		return combination(n-1, k-1) +  combination(n-1, k);	
	}
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		
		System.out.println(combination(n, k));
		
	}

}
