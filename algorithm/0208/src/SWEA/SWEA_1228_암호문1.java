package SWEA;

import java.util.*;

public class SWEA_1228_��ȣ��1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<=10;tc++) {
			LinkedList<Integer> List = new LinkedList<>();
			int N = sc.nextInt(); // ���� ��ȣ���� ����
			
			// ���� ��ȣ�� �Է�
			for (int i = 0; i < N; i++)
				List.add(sc.nextInt());
			
			int count = sc.nextInt(); // ��ɾ� ����
			
			// ��ɾ� ������ŭ �ݺ�
			for (int i = 0; i < count; i++) {
				String order = sc.next();
				int X = sc.nextInt(); // �տ��������� ��ġ
				int Y = sc.nextInt(); // ���Ե� ���� ����
				for (int j = 0; j < Y; j++) {
					List.add(X, sc.nextInt());
					X += 1;
				}
			}
			
            //���
			System.out.printf("#%d ",tc);
			for(int i=0;i<10;i++) {
				System.out.print(List.poll() + " ");
			}
			System.out.println();
		}
	}
}