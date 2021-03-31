package BOJ;

import java.util.Scanner;

public class BOJ_10819_�����ִ�� {
 
    static int N;
    static int[] arr, arr2; // �Է¹迭, �ӽù迭
    static boolean[] visited; // �湮Ȯ��
    static int result; // ����
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        result = 0;
        N = sc.nextInt();
        arr = new int[N];
        arr2 = new int[N];
        visited = new boolean[N];
 
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
 
        recursive(0);
        System.out.println(result);
 
    }
 
    private static void recursive(int index) {
 
        if (index == N) { // index�� ä���ٸ�
            int sum = 0; // �ʱ�ȭ
            // ���� �迭�� �� ���
            for (int i = 0; i < N - 1; i++)
                sum += Math.abs(arr2[i] - arr2[i + 1]);
            result = Math.max(result, sum);
            return;
        }
 
        for (int i = 0; i < N; i++) {
            if (visited[i] == true)
                continue;
            visited[i] = true; // �湮 ǥ��
            arr2[index] = arr[i]; // ���ο� �迭 �����
            recursive(index + 1); // ���
            visited[i] = false; // �湮 ����
        }
 
    }
}