package inflearn;
import java.util.*;

public class _54_�ùٸ���ȣ_������ {

    boolean solution(String s) {
        boolean answer = false;
        
        Stack<Character> a = new Stack<Character>();
        
        for(int i=0; i<s.length(); i++) {            
            if(s.charAt(i)=='(') {
                a.push(s.charAt(i));
            }
            //answer�� false�� �ʱ�ȭ �س��� �ٷ� return�� ����� �ð��ʰ��� ���� �ʴ´�.
            else {
                if(a.isEmpty()) {
                    return answer;
                } else if(a.pop()!='(') {
                    return answer;
                }
            }
        }
        
        if(a.isEmpty()) {
            answer = true;
        }
 
        return answer;
    }
}

//
//import java.util.Scanner;
//import java.util.Stack;
// 
//public class Main {
// 
//	public static void main(String[] args) {
// 
//		Scanner in = new Scanner(System.in);
//		
//		int T = in.nextInt();
//		
//		for(int i = 0; i < T; i++) {
//			System.out.println(solve(in.next()));	// nextLine()���� �ȵȴ�.
//		}
//	}
// 
//	public static String solve(String s) {
// 
//		Stack<Character> stack = new Stack<>();
// 
//		for (int i = 0; i < s.length(); i++) {
// 
//			char c = s.charAt(i);
// 
//			// ���� ��ȣ�� ��� ���ÿ� �ִ´�.
//			if (c == '(') {
//				stack.push(c);
//			}
// 
//			// �Ʒ��� ��� �ݴ� ��ȣ �� �����̴�.
// 
//			// ������ ����ִ� ���. ��, �ݴ� ��ȣ�� �Է¹޾����� pop�� ���Ұ� ���� ���
//			else if (stack.empty()) {
//				return "NO";
//			}
//			// �� ���� ��� stack ���Ҹ� pop �Ѵ�.
//			else {
//				stack.pop();
//			}
//		}
// 
//		/*
//		 * ��� �˻� ��ġ�� ���ÿ� �ܿ� ��Ұ� ������ ���� ��ȣ�� ���� ���� "NO" 
//		 * ������ ��������� ������ �����̹Ƿ� "YES" �̴�.
//		 */
// 
//		if (stack.empty()) {
//			return "YES";
//		} 
//		else {
//			return "NO";
//		}
//	}
//}