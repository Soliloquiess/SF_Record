package lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class JUN2493_Tower {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Tower> stack = new Stack<>();//ž ����
		int height, no;
		
		//6,9,5,7,4
		int N = Integer.parseInt(br.readLine());//ž����
		StringTokenizer st = new StringTokenizer(br.readLine());//ž ���̰� N������
		
		//�Է¹��� ž ���̸� �ϳ��� üũ
		for (no = 1;  no <= N; no++) {
			height = Integer.parseInt(st.nextToken());
			
			//stack �� üũ
			while(!stack.isEmpty()) {
				//��:height(������ ž), stack.peek()(����ž)
				if(stack.peek().height >= height) {//���þȿ� �ִ� ž�� ��ȣ�� �޾���
					System.out.print(stack.peek().no + " ");
					break;
				}				
				//�� ���� ž�̸� ������ �����ε� ��� ��ȣ�� �������ϱ� ����
				stack.pop();				
			}
			
			//��ó���̰ų� ������ �۾� �� ������ ����ų� �� ���
			if(stack.isEmpty()) {
				System.out.print(0 + " ");				
			}
			
			//�ڿ����� �ٸ����� ��ȣ�� ���� �� �����Ƿ� ���ÿ� ����.(��� ž��ü�� �ѹ����� �� ��)
			stack.push(new Tower(height, no));			
		}
	}
	
	static class Tower{
		int height;//ž����
		int no;//ž��ȣ
		
		public Tower(int height, int no) {			
			this.height = height;
			this.no = no;
		}		
	}
}
