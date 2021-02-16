package SWEA;

//public class SWEA_1223_����2 {
//
//}


import java.util.Scanner;

public class SWEA_1223_����2 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for(int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();
            String str = sc.next();
            
            char[] stack = new char[n+1]; // �����ڸ� ����
            char[] arr = new char[n+1]; // ��´�� ����
            int arr_index = 0; // arr �ε��� ����
            int top = -1; // ������ �ε��� ������
            
            for (int i = 0; i < n; i++) {
                
                char c = str.charAt(i);
                
                switch (c) {
                case '*':
                    // ���ÿ� ������ �켱������ ���� ���� ���� ���������� ������ arr�� ����
                    while(top > -1 && (stack[top] == '*')) {
                            arr[arr_index++] = stack[top];
                            top--;
                    }
                    stack[++top] = c;
                    break;
                    
                case '+':
                    // ���ÿ� ������ �켱������ ���� ���� ���� ���������� ������ arr�� ����
                    while(top > -1 && (stack[top] == '*' || stack[top] == '+')) {
                        arr[arr_index++] = stack[top];
                        top--;
                    }
                    stack[++top] = c;
                    break;
 
                default:
                    // ������ ��� �׳� ����
                    arr[arr_index++] = c;
                    break;
                }
            }
            // stack�� �����ִ� ���� arr�� ����
            while(top > -1) {
                arr[arr_index++] = stack[top--];
            }
            /*for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();*/
            
            
            int top2 = -1;
            int[] arr_num = new int[n]; // ����ǥ��� arr �߿��� ���ڸ� �����ϴ� ����
            
            for (int i = 0; i < arr.length-1; i++) {
                char c = arr[i];
                String c2 = Character.toString(c);
                //System.out.print("c : " + c + " ");
                int num1 , num2;
                
                if(c2.equals("+")) { // ���� �Ȱ�
                    num2 = arr_num[top2--];
                    num1 = arr_num[top2--];
                    arr_num[++top2] = num1 + num2;
                }
                else if(c2.equals("*")) { // *�� ���� arr_num���� �� �� ���� ���� �������ְ� �ε����� �� �� ������Ų �� �ű⿡ ����
                    num2 = arr_num[top2--];
                    num1 = arr_num[top2--];
                    arr_num[++top2] = num1 * num2;
                }
                else { // ���ڸ� �׳� ����
                    arr_num[++top2] = Integer.parseInt(c2);
                }
                
            }
            
            System.out.println("#" + tc + " " + arr_num[0]);
        }
        
        
    }
 
}
 
