package SWEA;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;
public class SWEA_1208_Flatten
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T =10;
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            //�־��� ���� Ƚ��
            int dump = sc.nextInt();
            //���� ���� �迭 �ʱ�ȭ
            int[] box = new int[100];
            for(int i=0; i<100; i++) {
                box[i] = sc.nextInt();
            }
            //���� ����
            Arrays.sort(box);
            while(true) {
                 
                box[99] -= 1;
                box[0] += 1;
                dump -= 1;
                 
                Arrays.sort(box);
                 
                if(box[99]-box[0]==0 || box[99]-box[0]==1) {// ���� ���� 1 �����̰ų�.
               //if(box[99]-box[0]<=1){
                	System.out.printf("#%d %d\n",test_case,box[99]-box[0]);
                    break;
                }else if(dump==0) {
                    System.out.printf("#%d %d\n",test_case,box[99]-box[0]);
                    break;
                }
            }
        }
    }
}