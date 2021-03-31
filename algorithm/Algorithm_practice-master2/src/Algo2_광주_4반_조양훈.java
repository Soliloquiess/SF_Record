import java.util.Arrays;
import java.util.Scanner;

public class Algo2_광주_4반_조양훈 {
	
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int []arr= new int[40000];

		int []arr2= new int[40000];
		int i;
		for(i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
//		int [] weight = {1,2,4,5,2};	//test
		
		int M = sc.nextInt();
		for(i=0;i<M;i++) {
			arr2[i]=sc.nextInt();
		}
		
		//이 아래로 일단 되는대로 그냥 막 짠 코드입니다..
		Arrays.sort(weight);
		if( weight[0]!=1) 
			return 1;
		int sum [] = new int[weight.length];
		int temp = 0;
		for(int i =0; i< weight.length;i++) {
			temp +=weight[i];
			sum[i] = temp;
			if(i<weight.length-1 && sum[i]+1<weight[i+1])
			{
				return sum[i]+1;
			}
		}
		
		return sum[sum.length-1]+1;
	}
		System.out.println(weight);
	}
}
