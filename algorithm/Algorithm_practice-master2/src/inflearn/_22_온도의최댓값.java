package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _22_�µ����ִ� {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		//freopen("input.txt", "rt", stdin);
		int n, k, i, sum = 0, res;
		st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine()," ");
		int []a = new int[n];
		for (i = 0; i < n; i++) {
			a[i] =Integer.parseInt(st.nextToken());

		}
		
		for (i = 0; i < k; i++) {	//���� �� �� (�־��� k ��ŭ) �� ���ϴ� ��
			//k�� 2�ϱ� �� ó���� ���ϴ°ų�. a[0]+a[1]�� ���ϰ� 
			sum = sum + a[i];
		}
		res = sum;
		for (i = k; i < n; i++) {	//���������� ���⼭ �� ��
			sum = sum + a[i] - a[i - k];		//�̷��� ���°� �� ���ٴ�. �ù�
			//sum = sum + (a[i] - a[i - k]);	
			//a[i]��° ( �� �ش�迭�� ���ϰ�) ���ӵ� �κ� ���� (�� �𸣰����� ���� ����)
			//�� ���ϰ� ���ϴ� �ε��� �� ���ϰ� �� �ڿ��� ���°�.

			if (sum > res) res = sum;	//(res=max�� sum ���� ũ�� sum�� max(res)�� ����)
		}
		System.out.println(res);
	}

}