package SWEA;

//public class SWEA_1983_������_����_�ű�� {
//
//}
//import java.util.*;
//
//public class SWEA_1983_������_����_�ű�� {
//	static class Student implements Comparable<Student>{
//		double grade;
//		int num;
//		
//		Student(double grade, int num){
//			this.grade = grade;
//			this.num = num;
//		}
//		
//		@Override
//		public int compareTo(Student s) {
//			if(this.grade > s.grade)
//				return -1;
//			else
//				return 1;
//		}
//	}
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String[] alpa = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
//		int test = sc.nextInt();
//		
//		for(int t = 1; t <= test; t++) {
//			ArrayList<Student> a = new ArrayList();
//			int n = sc.nextInt();
//			int target = sc.nextInt();
//			
//			for(int i = 1; i <= n; i++) {
//				double tmp1 = sc.nextDouble() * 35 / 100;
//				double tmp2 = sc.nextDouble() * 45 / 100;
//				double tmp3 = sc.nextDouble() * 20 / 100;
//				
//				a.add(new Student(tmp1 + tmp2 + tmp3, i));
//			}
//			Collections.sort(a);
//			for(int i = 0; i < a.size(); i++) {
//				Student tmp = (Student)a.get(i);
//				if(tmp.num == target) {
//					double idx = (double)i / a.size();
//					System.out.println("#" + t + " " + alpa[(int)(idx*10)]);
//				}
//			}
//		}
//	}
//}


import java.io.*;
import java.util.*;

public class SWEA_1983_������_����_�ű�� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] grade = {"D0","C-","C0","C+","B-","B0","B+","A-","A0","A+"};
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken())-1;
			int[] total = new int[N];
            
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int midScore = Integer.parseInt(st.nextToken());
				int finalScore = Integer.parseInt(st.nextToken());
				int homework = Integer.parseInt(st.nextToken());
				total[i] = midScore*35 + finalScore*45 + homework*20; //������ �� ��ü�� �߿����� �����Ƿ� ���������� �������.
			}
            
			int score = total[K];
			Arrays.sort(total);
			int index = -1;
			for(int i=0; i<N; i++) {
				if(total[i] == score) {
					index = i; //K��° �л��� ���� ��ġ
					break;
				}
			}
			int ans = index/(N/10);
			System.out.println("#"+tc+" "+grade[ans]);
		}
	}
}

//
//import java.util.*;
//
//public class SWEA_1983_������_����_�ű�� {
//	 static String[] score={"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt(); // �׽�Ʈ ���̽��� ����
//		for(int tc=1;tc<=T;tc++) {
//			int N = sc.nextInt(); //�л� ��
//			int K = sc.nextInt(); //�˰���� �л��� ��ȣ
//			
//			double find_score = 0.0; //K��ȣ�� ������ ã�� ���� ����
//			Double[] result = new Double[N];
//			
//			//�Է¹ޱ�
//			for(int i=0;i<N;i++) {
//				int mid_score = sc.nextInt();//�߰���� ����
//				int final_score = sc.nextInt();//�⸻��� ����
//				int sub_score = sc.nextInt();//���� ����
//				double sum = 0.35 * mid_score + 0.45 * final_score + 0.20 * sub_score; //����
//				result[i] = sum;
//				if(i+1==K) find_score = sum;
//			}
//			
//			Arrays.sort(result, Collections.reverseOrder());
//			
//			int index = 0;
//			for(int i=0;i<result.length;i++) {
//				if(result[i]==find_score) {
//					index = i;
//				}
//			}
//			
//			index = index / (N/10);
//			
//			System.out.printf("#%d %s\n",tc,score[index]);
//			
//		}
//	}
//}
//
//	
//
