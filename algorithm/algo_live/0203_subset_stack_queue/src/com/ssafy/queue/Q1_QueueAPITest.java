package com.ssafy.queue;

import java.util.LinkedList;
import java.util.Queue;
/**
 * @author THKim
 */
public class Q1_QueueAPITest {
	
	public static void main(String[] args) {
		
		Queue<String> queue = new LinkedList<String>();
		System.out.println(queue.isEmpty()+"//"+queue.size());
		queue.offer("������");
		queue.offer("������");
		queue.offer("��ȿ��");
		queue.offer("������");
		queue.offer("�ֿ켱");
		
		System.out.println(queue.isEmpty()+"//"+queue.size());
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty()+"//"+queue.size());
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}		
		
		System.out.println(queue.poll());
	}

}
