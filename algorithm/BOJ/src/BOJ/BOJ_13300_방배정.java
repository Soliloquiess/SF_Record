package BOJ;

//public class BOJ_13300_방배정 {
//
//}
import java.util.*;

public class BOJ_13300_방배정 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 여0 남1
        int[][] students = new int[2][6];
        int N = sc.nextInt();
        int K = sc.nextInt();
        for (int i=0; i<N; i++)
            students[sc.nextInt()][sc.nextInt()-1]++;
        int room = 0;
        for (int[] i : students)
            for (int j : i)
                if (j!=0) room += j%K == 0 ? j/K : j/K+1;
        System.out.print(room);
    }
}