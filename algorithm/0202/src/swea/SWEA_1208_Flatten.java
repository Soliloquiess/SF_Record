package swea;

import java.util.Arrays;
import java.util.Scanner;
 
public class SWEA_1208_Flatten {
 
    public static void main(String[] args)  {
            // TODO Auto-generated method stub
            Scanner sc = new Scanner(System.in);
            for(int i=1; i<=10; i++)
            {
                int dump = sc.nextInt();
                 
                int minPnt = 1;
                int maxPnt = 100;
                 
                int box[] = new int[101];
                 
                for(int j=1; j<=100; j++ )
                {
                    box[j] = sc.nextInt();
                }
                 
                Arrays.sort(box);
                int temp1=0,temp2=0;
                 
                 
                while (dump -- >0)
                {
                    temp1 = box[maxPnt];
                    temp2 = box[minPnt];
                    box[minPnt]++;
                    box[maxPnt]--;
                     
                    if(box[maxPnt-1] < temp1)
                        maxPnt = 100;
                    else
                        maxPnt -= 1;
                     
                    if( temp2 < box[minPnt+1])
                        minPnt = 1;
                    else
                        minPnt += 1;
                     
                }
                 
         
                 
                System.out.println("#"+i+" "+ (box[maxPnt]-box[minPnt]) );
                 
                 
            }
             
 
        }
 
    }