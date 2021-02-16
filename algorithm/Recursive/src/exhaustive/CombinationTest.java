package exhaustive;

import java.util.Arrays;

//nCr
public class CombinationTest {
	
	static int[] numbers;
	static int N=4, R=2;	//4���� 2��
	
	public static void main(String[] args) {
		numbers = new int[R];
		combination(0,1);	//1���� �̾ƾ�(�̴� ���ڰ� 1���� �����)
		//������ �Է¹��� ���� ����¥�°� �ƴ϶� 1���� �־��� N���� ¥�°Ŵϱ� 1���.
	}
	static void combination(int cnt, int start){	//start�� �̴� ��
		
		if(cnt==R)
		{
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = start; i<=N; i++) //i: �õ��ϴ� ��
			//���� ���� ���� i �̰� ��ŸƮ ���� �����϶�� ��.
		{
			numbers[cnt] =i;
			combination(cnt+1,i+1);
		}
	}
}
