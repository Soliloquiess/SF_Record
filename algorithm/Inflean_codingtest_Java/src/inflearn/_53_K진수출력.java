package inflearn;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;

public class _53_K진수출력
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
////C++의 stl이용
//#define _CRT_SECURE_NO_WARNINGS 
//#include<stdio.h>
//#include<vector>
//#include<stack>		//C++의 stl에서 제공하는 stack형 
//#include<algorithm>
//using namespace std;
//int main() {
//	//freopen("input.txt", "rt", stdin);
//	int n, k;
//	stack<int> s;	//스택에 정수형 넣는거.
//	char str[20] = "0123456789ABCDEF";//0번엔 0 초기화 1번엔 1초기화...쭉
//
//
//	scanf("%d %d", &n, &k);
//
//	while (n > 0) {
//		s.push(n % k);		//나머지를 푸시
//		n = n / k;			//n을 몫으로 바꿈
//	}
//	while (!s.empty()) {	//.empty는 스택이 비어있으면 참 리턴. 비어있지 않으면 false리턴.
//		printf("%c", str[s.top()]);	//스택의 맨 위 자료 참조하는 건. top()사용
//		//top는 빼지는 않고(끄집어 내는건 바로 밑의 pop 기능. 얘는 맨 위리턴만 해줌
//		//그리고 %c로 출력해야댐!
//		s.pop(); //top에서 리턴한거를 pop해줌.
//	}
//	return 0;
//}