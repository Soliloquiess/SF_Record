package BOJ;


import java.util.*;
import java.io.*;
 
// https://www.acmicpc.net/problem/1182
 
public class BOJ_1182_�κ�������_�� {
    static int count = 0;
    static int s;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
 
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
 
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
 
        powerSet(arr, n, 0, 0);        
        // s�� 0 �϶��� �κ����� �߿� �������� ��쵵 ī��Ʈ �� �� ����
        if(s == 0)
            count--;
        System.out.println(count);
    }
 
    static void powerSet(int[] arr, int n, int idx, int sum) {
        if(idx == n) {
            if(sum == s)
                count++;
            return;
        }
 
        powerSet(arr, n, idx + 1, sum);
        powerSet(arr, n, idx + 1, sum + arr[idx]);
    }
}

/*
��Ʈ ����ũ ���

import java.io.FileInputStream;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
 
        Scanner sc = new Scanner(new FileInputStream("input.txt"));
        //Scanner sc1 = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        int result = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //i�� 0000~1111����
        for (int i = 1; i < 1 << n; i++) {
 
            int bit = i;
            //0000 �� 
            //bit!=0 �� ���߿� �Ұ� ������ �� 0000111 �ϋ� 1�̰� ���� 0�̹Ƿ� �� �ʿ䰡 ����.
            for (int j = 0; bit != 0; j++, bit >>= 1) {
 
 
                //ù��° �ڸ��� 0�̸� j�� �����ʿ䰡 ����. ex) 10010�϶� j�� �ڸ��� 0�̹Ƿ� ���� �ʿ䰡 ���� �����̴�.
                if ((1 & bit) == 0){
                    continue;
                }
                sum = sum + arr[j];
            }
            if (sum == s) {
                result++;
            }
            sum = 0;
        }
        System.out.println(result);
 
    }
 
}
*/