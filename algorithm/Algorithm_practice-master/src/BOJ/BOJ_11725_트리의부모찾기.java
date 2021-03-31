package BOJ;

//public class BOJ_11725_Ʈ���Ǻθ�ã�� {
//
//}
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11725_Ʈ���Ǻθ�ã�� {
    static Scanner scanner = new Scanner(System.in);

    private static void bfs(int start, ArrayList<ArrayList<Integer>> list, int[] parents, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start); // ���� ������ ť�� �ִ´�.
        parents[start] = 1; // ���� ������ �湮�ߴٴ� ������ �����Ѵ�.

        // ť�� ������ ������ ������ �ݺ��Ѵ�.
        while(!queue.isEmpty()) {
            int parent = queue.poll();

            for(int item : list.get(parent)) {
                if(parents[item] == 0) {
                    parents[item] = parent;
                    queue.offer(item);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // ���� ����Ʈ
        ArrayList< ArrayList<Integer> > list = new ArrayList<>();
        int[] parents = new int[N+1];

        // �� ������ �������� ����Ǿ��ִ� �����鿡 ���� ������ ���� ����Ʈ�� �ʱ�ȭ
        for(int i=0; i<=N+1; i++) {
            list.add(new ArrayList<Integer>());
        }

        // ���� ����
        int a, b;
        for(int i=1; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            // ���⼺�� ���� �׷����̱� ������ ����Ǵ� ���ʿ� ���ο� ���� ������ �־��ش�.
            list.get(a).add(b);
            list.get(b).add(a);
        }

        // bfs
        int start = 1;
        bfs(start, list, parents, N);

        // ��� ���
        for(int i=2; i<parents.length; i++)
            System.out.println(parents[i]);
    }
}
