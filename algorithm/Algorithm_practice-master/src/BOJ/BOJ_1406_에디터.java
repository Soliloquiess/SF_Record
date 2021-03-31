package BOJ;

//public class BOJ_1406_������ {
//
//}

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

public class BOJ_1406_������ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());

		LinkedList<Character> list = new LinkedList<Character>();

		for(int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}

		//index ������ �̿��� cursor�� ��ġ�� �ٷ���� ��
		int index = list.size(); //ó�� ���۽� Ŀ���� ������ �� �ڿ��� �����ؾ��� (ex. abc|)

		for(int i = 0; i < M; i++) {
			String command = br.readLine();
			char c = command.charAt(0);
            
			switch(c) {
			case 'L':
				if(index != 0) {
					index = index - 1;
				}

				break;
			case 'D':
				if(index != list.size()) {
					index = index + 1;
				}

				break;
			case 'B':
				if(index != 0) {
					list.remove(index-1);
					index--;
				}
				break;
			case 'P':
				char t = command.charAt(2);
				list.add(index, t);
				index++;

				break;
			default:
				break;
			}
		}
		for(Character chr : list) {
			bw.write(chr);
		}
		
		bw.flush();
		bw.close(); 
	}
}

/*
 import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());

		LinkedList<Character> list = new LinkedList<Character>();

		for(int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}

		//index ������ �̿��� cursor�� ��ġ�� �ٷ���� ��
		int index = list.size(); //ó�� ���۽� Ŀ���� ������ �� �ڿ��� �����ؾ��� (ex. abc|)

		for(int i = 0; i < M; i++) {
			String command = br.readLine();
			char c = command.charAt(0);
            
			switch(c) {
			case 'L':
				if(index != 0) {
					index = index - 1;
				}

				break;
			case 'D':
				if(index != list.size()) {
					index = index + 1;
				}

				break;
			case 'B':
				if(index != 0) {
					list.remove(index-1);
					index--;
				}
				break;
			case 'P':
				char t = command.charAt(2);
				list.add(index, t);
				index++;

				break;
			default:
				break;
			}
		}
		for(Character chr : list) {
			bw.write(chr);
		}
		
		bw.flush();
		bw.close(); 
	}
}

*/

/*
 3. ListIterator ���
ListIterator�� Iterator�� ����� �������̽���.

Iterator�� �ܹ��� Ž���� �޸� ����� Ž���� �����ϴ�.

�׷��⿡ �� ����ó�� ��������� �̵��ϸ鼭 �����ϱ⿡ ȿ�����̴�.

Iterator / ListIterator
 
[Java] Iterator / ListIterator

Interface Iterator java.util Type Parameters : E - the type of elements returned by this iterator All Known Subinterfaces : ListIterator, XMLEventReader All Known Implementing Classes : BeanCo..

minhamina.tistory.com
3 �ڵ�
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());

		LinkedList<Character> list = new LinkedList<Character>();

		for(int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}

		//iterator �޼ҵ� ȣ�� 
		ListIterator<Character> iter = list.listIterator();
		//ó�� Ŀ���� ������ �� �ڿ� �־���ϱ� ������ Ŀ���� �ǵڷ� �̵������� (ex. abc|)
		while(iter.hasNext()) {
			iter.next();
		}
	
		for(int i = 0; i < M; i++) {
			String command = br.readLine();
			char c = command.charAt(0);
			switch(c) {
			case 'L':
				if(iter.hasPrevious())
					iter.previous();

				break;
			case 'D':
				if(iter.hasNext())
					iter.next();

				break;
			case 'B':
				//remove()�� next()�� previous()�� ���� ��ȯ�� ���� ������ ��Ҹ� ����Ʈ���� ������
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			case 'P':
				char t = command.charAt(2);
				iter.add(t);

				break;
			default:
				break;
			}
		}
		for(Character chr : list) {
			bw.write(chr);
		}
		
		bw.flush();
		bw.close(); 
	}
}
��� - ����
 */



/*
 4. Stack�� �̿��� ����
LinkedList�� �̿��� ���������� Stack�� �̿��Ѵٸ� ������� �ð� �ʰ��� �˿� ������ ���� �� �ִ�.

 

������ ��� ������ O(1)�� �ð� ���⵵�� ������ ������ �ð� �ʰ��� �ɸ��� �ʴ´�. (*�ð� ���⵵�� ���� ���� ���� �ʿ�)

Ŀ���� ���� ������ ������ ���� �� ���� ������ ����Ѵ�.

���� 1�� ���

 

abcd
3
P x
L
P y
 


�� ó�� Ŀ���� �Է� ���ڿ��� �� �ڿ� ��ġ�ϱ� ������ ���ڿ��� ��� ���� ���ÿ� �־��ش�.

���� ���ʷ� ��ɾ ó���ϸ鼭 Ŀ���� �������� �̵��ϸ� ���� ������ ���� ��� ��Ҹ� ������ ���ÿ� pop() �����ش�.

�׸��� Ŀ���� ���������� �̵��ϸ� ������ ������ ���� ��� ��Ҹ� ���� ���ÿ� pop() �����ָ� ��ġ Ŀ���� �̵��ϴ� ��ó�� �����Ѵ�.

 


������ ��� ��ɾ ó���� �Ŀ��� ������ LIFO �����̱� ������ ���� ������ ��� ��ҵ��� ������ ���ÿ� �ű� �� ������ ������ ��� pop() ��Ű�� ����� ����Ѵ�.

 

4 �ڵ�
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());

		Stack<String> leftSt = new Stack<String>();
		Stack<String> rightSt = new Stack<String>();
        
		//ó�� Ŀ���� ������ �� �ڿ��� �����ϱ� ������ ���� ���ÿ� �ʱ� ���ڸ� ��� �־��� (ex. abc|)
		String[] arr = str.split("");
		for(String s : arr) { //Enhanced For Loop ��� 
			leftSt.push(s); 
		}
		
		for(int i = 0; i < M; i++) {
			String command = br.readLine();
			char c = command.charAt(0);
			//StringTokenizer st = new StringTokenizer(reader.readLine());
			//String c = st.nextToken();
			
			switch(c) {
			case 'L':
				if(!leftSt.isEmpty())
					rightSt.push(leftSt.pop());

				break;
			case 'D':
				if(!rightSt.isEmpty())
					leftSt.push(rightSt.pop());

				break;
			case 'B':
				if(!leftSt.isEmpty()) {
					leftSt.pop();
				}
				break;
			case 'P':
				char t = command.charAt(2);
				leftSt.push(String.valueOf(t));
				//leftSt.push(st.nextToken());

				break;
			default:
				break;
			}
		}
        
		//Stack�� LIFO �����̱� ������
		//���� ���ÿ� �ִ� �����͵��� ��� ���������� �ű� �ڿ� �����ʿ� �ִ� ��� ������ ����Ѵ�.
		while(!leftSt.isEmpty())
			rightSt.push(leftSt.pop());
		
		while(!rightSt.isEmpty())
			bw.write(rightSt.pop());
		
		bw.flush();
		bw.close(); 
	}
}

*/
