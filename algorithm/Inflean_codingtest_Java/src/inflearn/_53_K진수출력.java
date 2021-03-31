package inflearn;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;

public class _53_K�������
{
    public static void main (String[] args) throws java.lang.Exception
    {
        
//        System.setIn(new FileInputStream("input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String str = "0123456789ABCDEF";
        char[] ch = new char[str.length()];

        for(int i = 0;i<str.length();i++){
            ch[i] = str.charAt(i);
        }

        Stack<Integer> stack = new Stack<>();

        while(n != 0){
            stack.push(n%k);
            n = n/k;
        }

        while(!stack.empty()){
            System.out.print(ch[stack.pop()]);
        }


    }
}

//
//#define _CRT_SECURE_NO_WARNINGS 
//#include<stdio.h>
//#include<vector>
//#include<algorithm>
//using namespace std;
//int stack[100], top = -1;
//
//void push(int x) {
//	stack[++top] = x;
//}
//int pop() {
//	return stack[top--];
//}
//
//int main() {
//	//freopen("input.txt", "rt", stdin);
//	int n, k;
//	char str[20] = "0123456789ABCDEF";
//	scanf("%d %d", &n, &k);
//	while (n > 0) {
//		push(n % k);
//		n = n / k;
//	}
//	while (top != -1) {
//		printf("%c", str[pop()]);
//	}
//	return 0;
//}
//
//
//-------------
////C++�� stl�̿�
//#define _CRT_SECURE_NO_WARNINGS 
//#include<stdio.h>
//#include<vector>
//#include<stack>		//C++�� stl���� �����ϴ� stack�� 
//#include<algorithm>
//using namespace std;
//int main() {
//	//freopen("input.txt", "rt", stdin);
//	int n, k;
//	stack<int> s;	//���ÿ� ������ �ִ°�.
//	char str[20] = "0123456789ABCDEF";//0���� 0 �ʱ�ȭ 1���� 1�ʱ�ȭ...��
//
//
//	scanf("%d %d", &n, &k);
//
//	while (n > 0) {
//		s.push(n % k);		//�������� Ǫ��
//		n = n / k;			//n�� ������ �ٲ�
//	}
//	while (!s.empty()) {	//.empty�� ������ ��������� �� ����. ������� ������ false����.
//		printf("%c", str[s.top()]);	//������ �� �� �ڷ� �����ϴ� ��. top()���
//		//top�� ������ �ʰ�(������ ���°� �ٷ� ���� pop ���. ��� �� �����ϸ� ����
//		//�׸��� %c�� ����ؾߴ�!
//		s.pop(); //top���� �����ѰŸ� pop����.
//	}
//	return 0;
//}