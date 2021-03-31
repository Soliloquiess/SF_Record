package BOJ;


import java.util.Scanner;
 
public class BOJ_10972_�������� {
    
    public static void swap(int [] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
     public static boolean nextPermutation(int[] a) {
             //1. a[i-1] < a[i]�� �����ϴ� ù ��° �� ã��
            int i = a.length-1;
            while (i > 0 && a[i-1] >= a[i]) {
                i -= 1;
            }
 
            // ������ ������ ���
            if (i <= 0) {
                return false;
            }
           //2. a[i-1] < a[j]�� �����ϴ� ù ��° �� ã��
            int j = a.length-1;
            while (a[j] <= a[i-1]) {
                j -= 1;
            }
            
            //3. a[i-1]�� a[j] swap
            swap(a, i-1, j);
 
            //4 i���� a.length-1���� ���� ������
            j = a.length-1;
            while (i < j) {
                swap(a, i, j);
                i += 1;
                j -= 1;
            }
            return true;
        }
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i=0; i<n; i++) {
                a[i] = sc.nextInt();
            }
            if (nextPermutation(a)) {
                for (int i=0; i<n; i++) {
                    System.out.print(a[i] + " ");
                }
            } 
            else {
                System.out.println("-1");
            }
        }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
// 
////���� ����
//public class Baekjoon10972 {
// 
//    public static void main(String[] args) throws NumberFormatException, IOException {
//        
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
//        int N = Integer.parseInt(br.readLine()); 
//        int arr[] = new int[N];
//        
//        StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
//        
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        
//        if (nextPermutation(arr)) {
//            for (int i = 0; i < N; i++) {
//                System.out.print(arr[i] + " ");
//            }
//            System.out.println();
//        } else {
//            System.out.println("-1");
//        }
//    }
//    
//    public static boolean nextPermutation(int[] arr) {
//        
//        //�ڿ������� Ž���ϸ鼭 a-1���� a�� �� ū ��� ã��
//        int a = arr.length - 1;
//        while(a > 0 && arr[a-1] >= arr[a]) a--;
//        if (a <= 0 ) return false;
//        
//        //�ٽ� �ڿ������� Ž���ϸ� a-1���� b�� �� ū ��� ã��
//        int b = arr.length - 1;
//        while(arr[a-1] >= arr[b]) b--;
//        
//        //a�� b�� swap
//        int tmp = arr[a-1];
//        arr[a-1] = arr[b];
//        arr[b] = tmp;
//        
//        //a�������� �������� �������� ���� 
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
//https://jiwontip.tistory.com/13?category=316038 �� ���Բ��� ���� ���� �ƴ�.
