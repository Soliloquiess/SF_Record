package exhaustive;

import java.util.Arrays;

//nCr
public class CombinationTest {
	
	static int[] numbers;
	static int N=4, R=2;	//4개중 2개
	
	public static void main(String[] args) {
		numbers = new int[R];
		combination(0,1);	//1부터 뽑아야(뽑는 숫자가 1부터 출발함)
		//지금은 입력받은 수로 조합짜는게 아니라 1부터 주어진 N까지 짜는거니까 1줘야.
	}
	static void combination(int cnt, int start){	//start는 뽑는 수
		
		if(cnt==R)
		{
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = start; i<=N; i++) //i: 시도하는 수
			//현재 뽑은 수는 i 이걸 스타트 부터 시작하라는 뜻.
		{
			numbers[cnt] =i;
			combination(cnt+1,i+1);
		}
	}
}
