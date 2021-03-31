package BOJ;


import java.util.Scanner;
 
public class BOJ_10972_다음순열 {
    
    public static void swap(int [] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
     public static boolean nextPermutation(int[] a) {
             //1. a[i-1] < a[i]를 만족하는 첫 번째 수 찾기
            int i = a.length-1;
            while (i > 0 && a[i-1] >= a[i]) {
                i -= 1;
            }
 
            // 마지막 순열인 경우
            if (i <= 0) {
                return false;
            }
           //2. a[i-1] < a[j]를 만족하는 첫 번째 수 찾기
            int j = a.length-1;
            while (a[j] <= a[i-1]) {
                j -= 1;
            }
            
            //3. a[i-1]과 a[j] swap
            swap(a, i-1, j);
 
            //4 i부터 a.length-1까지 순열 뒤집기
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
////다음 순열
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
//        //뒤에서부터 탐색하면서 a-1보다 a가 더 큰 경우 찾음
//        int a = arr.length - 1;
//        while(a > 0 && arr[a-1] >= arr[a]) a--;
//        if (a <= 0 ) return false;
//        
//        //다시 뒤에서부터 탐색하며 a-1보다 b가 더 큰 경우 찾음
//        int b = arr.length - 1;
//        while(arr[a-1] >= arr[b]) b--;
//        
//        //a랑 b를 swap
//        int tmp = arr[a-1];
//        arr[a-1] = arr[b];
//        arr[b] = tmp;
//        
//        //a에서부터 끝까지를 오름차순 정렬 
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
//https://jiwontip.tistory.com/13?category=316038 이 형님꺼도 도움 많이 됐다.
