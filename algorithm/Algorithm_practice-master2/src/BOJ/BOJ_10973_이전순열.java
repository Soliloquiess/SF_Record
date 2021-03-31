package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
//이전 순열
public class BOJ_10973_이전순열 {
 
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
        
        //뒤에서부터 탐색해서 a-1가 a보다 큰 경우 찾음
        int a = arr.length - 1;
        while(a > 0 && arr[a-1] <= arr[a]) a--;
        if (a <= 0) return false;
        
        //다시 뒤에서부터 탐색하며 a-1가 b보다 큰 경우 찾음
        int b = arr.length - 1;
        while(arr[a-1] <= arr[b]) b--;
        
        //a-1와 b를 swap
        int tmp = arr[a-1];
        arr[a-1] = arr[b];
        arr[b] = tmp;
        
        //a부터 끝까지 내림차순 정렬 (swap이용) 
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
////이전 순열
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
//        //뒤에서부터 탐색해서 a-1가 a보다 큰 경우 찾음
//        int a = arr.length - 1;
//        while(a > 0 && arr[a-1] <= arr[a]) a--;
//
//    ////다음순열과 부호만 반대(arr[a-1] >= arr[a])
//        if (a <= 0) return false;
//        
//        //다시 뒤에서부터 탐색하며 a-1가 b보다 큰 경우 찾음
//        int b = arr.length - 1;
//        while(arr[a-1] <= arr[b]) b--; //다음순열과 부호만 반대
//        
//        //a-1와 b를 swap
//        int tmp = arr[a-1];
//        arr[a-1] = arr[b];
//        arr[b] = tmp;
//        
//        //a부터 끝까지 내림차순 정렬 (swap이용) 
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