package BOJ;

//public class BOJ_13300_����� {
//
//}
import java.util.*;

public class BOJ_13300_����� {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // ��0 ��1
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