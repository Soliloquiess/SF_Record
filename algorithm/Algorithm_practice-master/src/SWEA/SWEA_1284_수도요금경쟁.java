package SWEA;

//public class SWEA_1284_������ݰ��� {
//
//}


import java.util.*;
public class SWEA_1284_������ݰ��� {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T, x;
        T = sc.nextInt();
        
        int P, Q, R, S, W;
        int A, B, charge;
        for(x=1; x<=T; x++) {
            P = sc.nextInt();
            Q = sc.nextInt();
            R = sc.nextInt();
            S = sc.nextInt();
            W = sc.nextInt();

            A = P * W;
            if( W <= R ) B = Q;
            else B = Q + ( W-R ) * S;
            
            charge = Math.min(A,B);
            System.out.format("#%d %d\n",x,charge);
        }
    }
}

/*

import java.io.*;
import java.util.StringTokenizer;

public class Solution {

	static int P,Q,R,S,W;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			P = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
            
			int chargeA = W*P; //A���� �������
			int chargeB;
			
            
            //B���� ������� ���
			if(W <= R) {
				chargeB = Q; // �⺻���
			} else {
				int extra = W-R;
				chargeB = Q + extra*S;
			}
			
			if(chargeA > chargeB) {
				System.out.println("#"+tc+" "+chargeB);
			} else {
				System.out.println("#"+tc+" "+chargeA);
			}
		}
	}

}

*/