package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c1861 {
	
	static int [][] map;
	static int [][] chk;
	static int result,num = 999999999;
	
	static int search(int i,int j,int d,int len) {
		chk[i][j] = 1;
		if(i-1>=0 && map[i-1][j] == map[i][j] + d) len = search(i-1,j,d,++len);
		else if(i+1<map.length && map[i+1][j] == map[i][j] + d) len = search(i+1,j,d,++len);
		else if(j+1<map.length && map[i][j+1] == map[i][j] + d) len = search(i,j+1,d,++len);
		else if(j-1>=0 && map[i][j-1] == map[i][j] + d) len = search(i,j-1,d,++len);
		//result�� ������ ������, num ���� ���簪�� �۴ٸ� ����.
		if(d == -1 && result <= len) {
             // ���� ���� result = len; �� �����س��� �Ʒ����� numó���ϴϱ� �ȵ��� ���ó�!!!!       
            int temp = map[i][j];
            
            if(result < len) num = temp;
            else if(result == len && num > temp) num = temp;
            result = len;
        
        }
		return len;
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			chk =  new int[N][N];//���� Ž���ߴ��� üũ�� �迭
			//�Է�
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		
			result = 0;
			int len;
			
			for(int i=0;i<N;i++) {//1~N*N ���� ��� ����� Ž��
				for(int j=0;j<N;j++) {
					if(chk[i][j] == 0) {
						len = search(i,j,1,1);//�����ϴ� �� ,����
						search(i,j,-1,len);//�����ϴ� �� ,�Ӹ�
					}
				}
			}
			
			System.out.println("#"+t+ " " + num + " " + result);
			
		}
	}
}