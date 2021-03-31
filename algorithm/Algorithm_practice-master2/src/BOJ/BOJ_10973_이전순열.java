package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
//���� ����
public class BOJ_10973_�������� {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        if(prePermutation(arr)) {
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("-1");
        }
    }    
 
    public static boolean prePermutation(int[] arr) {
        
        //�ڿ������� Ž���ؼ� a-1�� a���� ū ��� ã��
        int a = arr.length - 1;
        while(a > 0 && arr[a-1] <= arr[a]) a--;
        if (a <= 0) return false;
        
        //�ٽ� �ڿ������� Ž���ϸ� a-1�� b���� ū ��� ã��
        int b = arr.length - 1;
        while(arr[a-1] <= arr[b]) b--;
        
        //a-1�� b�� swap
        int tmp = arr[a-1];
        arr[a-1] = arr[b];
        arr[b] = tmp;
        
        //a���� ������ �������� ���� (swap�̿�) 
        int start = a;
        int end = arr.length - 1;
        while(start < end) {
            tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
        return true;
    }
}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
// 
////���� ����
//public class Baekjoon10973 {
// 
//    public static void main(String[] args) throws NumberFormatException, IOException {
//    
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        
//        int arr[] = new int[N];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        
//        if(prePermutation(arr)) {
//            for (int i = 0; i < N; i++) {
//                System.out.print(arr[i] + " ");
//            }
//            System.out.println();
//        } else {
//            System.out.println("-1");
//        }
//    }    
// 
//    public static boolean prePermutation(int[] arr) {
//        
//        //�ڿ������� Ž���ؼ� a-1�� a���� ū ��� ã��
//        int a = arr.length - 1;
//        while(a > 0 && arr[a-1] <= arr[a]) a--;
//
//    ////���������� ��ȣ�� �ݴ�(arr[a-1] >= arr[a])
//        if (a <= 0) return false;
//        
//        //�ٽ� �ڿ������� Ž���ϸ� a-1�� b���� ū ��� ã��
//        int b = arr.length - 1;
//        while(arr[a-1] <= arr[b]) b--; //���������� ��ȣ�� �ݴ�
//        
//        //a-1�� b�� swap
//        int tmp = arr[a-1];
//        arr[a-1] = arr[b];
//        arr[b] = tmp;
//        
//        //a���� ������ �������� ���� (swap�̿�) 
//        int start = a;
//        int end = arr.length - 1;
//        while(start < end) {
//            tmp = arr[start];
//            arr[start] = arr[end];
//            arr[end] = tmp;
//            start++;
//            end--;
//        }
//        return true;
//    }
//}