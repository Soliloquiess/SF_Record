package BOJ;

import java.util.*;

public class BOJ_13300_�����_������ڵ� {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // ��0 ��1
        int[][] a = new int[2][6];
        int N = sc.nextInt();
        int K = sc.nextInt();
        for (int i=0; i<N; i++)
        	{
        		int S = sc.nextInt();
        		int Y = sc.nextInt()-1;	//�ε��� ������. 6+1 ���� �״�� 1���� ��� ���� �� �� �ְ����� �ƹ�ư �̷���.
        		a[S][Y]++;
        	}
     
//        for(int[] ia : a) {
//        	System.out.println(Arrays.toString(ia));
//        }
        
        
//        int room = 0;
//        for (int[] i : students)
//            for (int j : i)
//                if (j!=0) room += j%K == 0 ? j/K : j/K+1;
//        System.out.print(room);
        int min = 0;
        for(int i =0; i<2;i++) {
        	for(int j =0; j<6;j++) {
        		if(a[i][j]!=0) {
        			min+=a[i][j]%K ==0 ?
        						a[i][j]/K :
        								a[i][j]/K+1;
        		}
        	}
        }
        System.out.println(min);
    }
}