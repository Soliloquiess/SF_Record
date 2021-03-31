package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_3289_���μ����� {

	private static int N,M; //���Ҽ� , �Է����� �־����� ������ ����
	private static int[] parents; //��ǥ�� �迭
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int command,a,b;
		
		for(int t = 1; t<=T; ++t) {
			N=sc.nextInt();
			M = sc.nextInt();
			parents = new int[N+1];
			
			//�� ���Һ� ��ǥ��(�θ�)�� ����
			Arrays.fill(parents, -1);	//make-set

			StringBuilder builder = new StringBuilder();
			
			builder.append("#").append(t).append(" ");
		
			for(int i = 0; i<=M; i++)
			{
				command = sc.nextInt();
				a = sc.nextInt();
				b = sc.nextInt();
				
				//Ŀ�ǵ尪�� ���Ŀ� ���� �ٸ��� �۾� ����
				
				switch(command) {
					case 0:
						union(a,b);
						break;
					case 1:		//���������̸� ��ǥ�ڸ� ã�� ���ϴ� �۾� �ؾ�.
							//a��ǥ�� ã�� ����� b�� ��ǥ�� ã�� ��� ���ϸ鼭 ����
						//������ 1��� �ƴϸ� 0 ���.
						//���ؼ� ������ ��ġ�°� �ƴ϶� ������ 1 �ٸ��� 0
						builder.append(find(a) == find(b)?"1":"0");
						break;
				}//switch
			}//for
			System.out.println(builder);
		}
	}
	
	private static int find(int a) {	//a�� �θ� ã�°�
		if(parents[a] ==-1) {
			return a;
		}
		return parents[a] = find(parents[a]); 	//a�θ��� �θ� ã�� �۾� �׷��� ���� ����� �ڱ� �ڽ��� parent�� �ش�.
	}
	
	private static boolean union(int a, int b) {	//�¶��� ���Ƕ� Ǯ������ �״�� ���
		int aRoot = find(a);
		int bRoot = find(b);
		//����� �Ű������θ� ���� ¯ ���� ��ġ�� ��.
		if(aRoot == bRoot) {	//�� ������ ¯�� ���� ��Ȳ�̸� �̹� ���� �����̹Ƿ� ��ĥ �ʿ䰡 ����.
			return false;	//��ġ�� ���� ��� ����.
		}
		
		parents[bRoot] = aRoot;	//aRoot�� �� ������ b�� �ִ°� �ƴ϶� b�Ǻθ� �����ؼ� ��ǥ�ڿ� ��ǥ�ڳ��� �۾��ϰ� ��.
		//b�� ��ǥ�� �������.
		//�̰� �� ����ϸ� ���� Ǯ�� �����ϱ� ����.
		//b��Ʈ�� �θ� a��Ʈ�� �ٲ���.
		return true;
		//���߿� ��ũ �̿��ϸ� ��ũ ���ؼ� ��ũ�� ���� �ʿ� ���� �� ���̰� ���� ��ũ ������ �ڽ��� ��ũ �ϳ� �÷��ִ� �̷� �ڵ尡 �ʿ�
		//path ���������� ��ũ ���� ��������.
	}
}
