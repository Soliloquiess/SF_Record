
import java.util.Arrays;
//���̸� ���� ��� ���� ����@_@ ȭ����!
//�̰� ���� �߿� ����! �޴޴޴� �ܿ�� �����ϰ� �׷�����
//���� 2~3�ϰ� ���ʹ� �׷����� 10�� �̻� �� ���� �ĺþ��!
public class �������������� {
    static int[] arr= {1,2,3,4};
    static boolean[] visited;
    static int[] resul;
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        visited=new boolean[arr.length];
        //4�� �߿� 2�� �̴� �����Դϴ�
        resul=new int[2];
        System.out.println("***���� ���(N��M(1))***");
        perm(0);
        System.out.println("***���� ���(N��M(2))***");
        combi(0,0);
        System.out.println("***�ߺ� ���� ���(N��M(3))***");
        re_perm(0);
        System.out.println("***�ߺ� ���� ���(N��M(4))***");
        re_combi(0,0);
        System.out.println("***powerSet ���***");
        //�������� visited�迭 ����߾��� ������ �ٽ� �ʱ�ȭ
        Arrays.fill(visited, false);
        powerSet(0);
    }
    
    //������ ���ڰ� �ϳ�!(��� �迭�� �ε���)=>arr�� �ε����� for���� ���� �˻�
    //������ ������ �ϳ�!
    static void perm(int c) {
        if(c==resul.length) {
            System.out.println(Arrays.toString(resul));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            //�湮�� �� ���ٸ�~
            if(visited[i]==false) {
                resul[c]=arr[i];
                visited[i]=true;
                perm(c+1);
                visited[i]=false;
            }
        }
    }
    //������ ���ڰ� �ΰ�(��� �迭�� �ε���/ arr �ε���)
    //������ ������ �ΰ�
    static void combi(int n,int c) {
        if(c==resul.length) {
            System.out.println(Arrays.toString(resul));
            return;
        }
        if(n==arr.length) return;
        
        resul[c]=arr[n];
        //arr�� ���� ���ڸ�
        //resul �迭�� ��°��!
        combi(n+1,c+1);
        //resul �迭�� ���� �ʴ� ���(c+1�� �ƴ϶�� ���� �߿�)
        combi(n+1,c);
    }
    //�ߺ�����
    //���������� visited �迭 �ʿ������=>�ߺ��� �����ϱ� ������!
    static void re_perm(int c) {
        if(c==resul.length) {
            System.out.println(Arrays.toString(resul));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            resul[c]=arr[i];
            re_perm(c+1);
        }
    }
    //�ߺ�����
    //���� n�� for���� i���踦 �ľ��ϴ°� �߿�!
    static void re_combi(int n,int c) {
        if(c==resul.length) {
            System.out.println(Arrays.toString(resul));
            return;
        }
        for (int i = n; i < arr.length; i++) {
            resul[c]=arr[i];
            re_combi(i, c+1);
        }
    }
    //�κ�����
    //arr�迭 �ϳ��� �˻��� ���� idx �ϳ��� �ʿ�!
    //������ �Բ� visited �迭�� �ʿ��� �κ����ձ��ϱ�!
    //true,false�� �����ϰ�=> arr��� ������ ������ ������ true�� ���� ����ϱ�
    static void powerSet(int idx) {
        //��°���� 2^4=16�� �̴�!(�� ���  false�� ���� ���� �� ���� �� �ֽ��ϴ�!)
        if(idx==arr.length) {
            for (int i = 0; i < arr.length; i++) {
                if(visited[i]==true) System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        visited[idx]=true;
        powerSet(idx+1);
        visited[idx]=false;
        powerSet(idx+1);
    }
}