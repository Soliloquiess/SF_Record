package BOJ;
import java.util.Arrays;
import java.util.Scanner;
 
public class BOJ_2309_�ϰ������� {
    static int[] arr,visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[9];
        visited = new int[9];
        for(int i=0;i<9;i++)
            arr[i] = sc.nextInt();
        solve(0,0,0);
    }
    
    // Ű�� ���� 100, �ϳ��� ����ϸ� �ǹǷ� ����� flag�� �������´�.
    static boolean flag = false;
    private static void solve(int idx,int cnt,int sum) {
        if(flag) return;
        // 7���� ����� ��
        if(cnt==7) {
            // ���� 100�̶�� 
            if(sum==100) {
                int[] result = new int[7];
                // 7�� üũ�� ���� �޾�. ����Ѵ�.
                for(int i=0,index=0;i<9;i++)
                    if(visited[i]==1) result[index++]=arr[i];
                Arrays.sort(result);
                for(int i:result)
                    System.out.println(i);
                flag = true;
            }
            return;
        }
        if(idx>=9) return;
        // ���� ����
        visited[idx] = 1;
        solve(idx+1,cnt+1,sum+arr[idx]);
        visited[idx] = 0;
        
        // ���� ������
        solve(idx+1,cnt,sum);
    }
}