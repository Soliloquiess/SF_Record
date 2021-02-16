package com.ssafy.subset;

import java.util.Stack;
/**
 * @author THKim
 */
public class St1_StackAPITest {

	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<String>();
		
		System.out.println(stack.isEmpty()+"//"+stack.size());
		
		stack.push("최지우");
		stack.push("고소영");
		stack.push("전지현");
		
		System.out.println(stack.isEmpty()+"//"+stack.size());
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty()+"//"+stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty()+"//"+stack.size());
		System.out.println(stack.pop());				
		
	}
}



