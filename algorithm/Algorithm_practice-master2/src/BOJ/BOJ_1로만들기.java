package BOJ;

import java.util.*;

public class BOJ_1로만들기 {

    static int memo[] = new int[1000001];

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

	    System.out.println(minMath(sc.nextInt()));
    }

    static int minMath(int n){
        if(n==1)
            return 0;
        if(n==2 || n==3){
            return 1;
        }

        if(memo[n]!=0)
            return memo[n];
        
        if(n%2==0&&n%3==0){
            memo[n] = Math.min(minMath(n/3),minMath(n/2))+1;
        }else if(n%2==0){
            memo[n] = Math.min(minMath(n/2), minMath(n-1))+1;
        }else if(n%3==0){
            memo[n] = Math.min(minMath(n/3), minMath(n-1))+1;
        }else{
            memo[n] = minMath(n-1)+1;
        }
        return memo[n];
    }
}
