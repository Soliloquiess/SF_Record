package lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class JUN2493_Tower {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Tower> stack = new Stack<>();//탑 저장
		int height, no;
		
		//6,9,5,7,4
		int N = Integer.parseInt(br.readLine());//탑갯수
		StringTokenizer st = new StringTokenizer(br.readLine());//탑 높이가 N개들어옴
		
		//입력받은 탑 높이를 하나씩 체크
		for (no = 1;  no <= N; no++) {
			height = Integer.parseInt(st.nextToken());
			
			//stack 안 체크
			while(!stack.isEmpty()) {
				//비교:height(오른쪽 탑), stack.peek()(왼쪽탑)
				if(stack.peek().height >= height) {//스택안에 있던 탑이 신호를 받아줌
					System.out.print(stack.peek().no + " ");
					break;
				}				
				//더 낮은 탑이면 어차피 앞으로도 계속 신호를 못받으니까 삭제
				stack.pop();				
			}
			
			//맨처음이거나 위에서 작업 중 스택이 비었거나 한 경우
			if(stack.isEmpty()) {
				System.out.print(0 + " ");				
			}
			
			//뒤에오는 다른애의 신호를 받을 수 있으므로 스택에 넣음.(모든 탑객체가 한번씩은 다 들어감)
			stack.push(new Tower(height, no));			
		}
	}
	
	static class Tower{
		int height;//탑높이
		int no;//탑번호
		
		public Tower(int height, int no) {			
			this.height = height;
			this.no = no;
		}		
	}
}
