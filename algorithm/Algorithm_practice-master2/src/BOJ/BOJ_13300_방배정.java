package BOJ;
import java.util.*;

//public class BOJ_13300_����� {
	
	

import java.util.*;

public class BOJ_13300_����� {
	
	static int male[] = new int[7];
	static int female[] = new int[7];
	public static void main(String[] args) {
		
	
		 Scanner sc = new Scanner(System.in);
	    int n,k;
//	    cin >> n >> k;
	    n = sc.nextInt();
	    k = sc.nextInt();
	    for(int i = 0; i < n; i++){
	        int gender;
	        int grade;
//	        cin >> gender >> grade;
	         gender = sc.nextInt();
	         grade = sc.nextInt();
	        if(gender==0){
	            female[grade]++;
	        }else{
	            male[grade]++;
	        }
	    }
	    int room = 0;
	    for(int i = 1; i <= 6; i++){
	        if(male[i] % k == 0) room += male[i] / k;
	        else room += male[i]/k+1;
	    }
	    for(int i = 1; i <= 6; i++){
	        if(female[i] % k == 0) room += female[i] / k;
	        else room += female[i]/k+1;
	    }
//	    cout << room << '\n';
	    System.out.println(room);
	}
}
	
	
	
//	static int N; // ���п��࿡ �����ϴ� �л� ��
//	static int K; // �� �濡 ������ �� �ִ� �ִ� �ο� ��
//	static int[][] student; // �л� �Է�
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt(); // ���п��࿡ �����ϴ� �л� ��
//		K = sc.nextInt(); // �� �濡 ������ �� �ִ� �ִ� �ο� ��
//		
//		student = new int[7][2];
//		
//		for(int i=0;i<N;i++) {
//			int sex = sc.nextInt(); // ���� �Է� ���л��� 0, ���л��� 1
//			// ���л��̸� 0�� �ε����� �г⸸ŭ 1�� ����
//			if(sex==0) student[sc.nextInt()][0]++;
//			// ���л��̸� 0�� �ε����� �г⸸ŭ 1�� ����
//			else if(sex==1) student[sc.nextInt()][1]++;
//		}
//		
//		int count = 0; // ���� ����	
//		
//		//���л� Ž��
//		for(int i=1;i<7;i++) {
//			//�л� ���� ���ٸ� ó������
//			if(student[i][0]==0) continue;
//			
//			//K���� �۰ų� ������ count 1 ����
//			else if(student[i][0]<=K) count++;
//			//K�� �����µ� �������� 0�̶�� ��ŭ count ����
//			else if(student[i][0]%K==0) count += student[i][0] / K;
//			//K�� �����µ� �������� 0�̾ƴ϶�� ��ŭ �����ϰ�, 1����
//			else if(student[i][0]%K!=0) {
//				count+=student[i][0] / K;
//				count++;
//			}
//		}
//		
//		//���л� Ž��
//		for(int i=1;i<7;i++) {
//			//�л� ���� ���ٸ� ó������
//			if(student[i][1]==0) continue;
//			
//			//K���� �۰ų� ������ count 1 ����
//			else if(student[i][1]<=K) count++;
//			//K�� �����µ� �������� 0�̶�� ��ŭ count ����
//			else if(student[i][1]%K==0) count += student[i][1] / K;
//			//K�� �����µ� �������� 0�̾ƴ϶�� ��ŭ �����ϰ�, 1����
//			else if(student[i][1]%K!=0) {
//				count+=student[i][1] / K;
//				count++;
//			}
//		}
//		
//		//count ���
//		System.out.println(count);
//	}
//}


//
//public class Main {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(bf.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int K = Integer.parseInt(st.nextToken());
//		int room = 0;
//		// 1 ~ 6�г� , �� & �� ����
//		int[][] student = new int[7][2];
//		
//		// �� �г⺰ ���л�, ���л� �����ؼ� ī��Ʈ
//		for(int i=0; i<N; i++) {
//			st = new StringTokenizer(bf.readLine());
//			int a = Integer.parseInt(st.nextToken());	// ����
//			int b = Integer.parseInt(st.nextToken());	// �г�
//			if(a == 0) student[b][0] ++;	// ���� => [�г�][0] ++
//			else 	student[b][1] ++;       // ���� => [�г�][1] ++
//		}
//		
//		for(int i=1; i<student.length; i++) {
//			for(int j=0; j<student[i].length; j++) {
//				if(student[i][j] == 0)	continue;	// i�г� �л��� ���� ��� => �� �ʿ���� ���
//				room += student[i][j] / K;	// �ʿ��� �� ���
//				if(student[i][j] % K != 0)	// ���� �л��� ������ �������� ������ �� �ϳ� �� �ʿ�
//					room += 1;
//			}
//		}
//		System.out.println(room);
//		bf.close();
//	}
//
//}

