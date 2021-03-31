package Map;


import java.util.*;

public class MapTest1 {

	public static void main(String[] args) {

		String s = "inflearn in love";
		System.out.println(Solve(s));

	}

	public static int Solve(String s) {
		
		//1-1.����üũ
		if (s == null || s.length() == 0)
			return -1;
		//1-2.�ʿ� ����. ���� �׸�(data structure)
		Map<Character, Integer> map = new HashMap();
		
		//2.
		for (char ch : s.toCharArray()) {	//s�� char�� �迭�� ����.
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			//�� getOrDefault�� �ǹ����� ���� ���µ� �ٷ� ���� �ּ�ó���� 31~39��
//			�� �޼���� �����س���.
			
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			//ch��� Ű�� �ְ� �� �� ������� ����.
			//ch�� �����ϸ� ch�� �������� �����´�.
			//ch�� ���� ���ϸ� 0�� �����´�.
			//����� �� getOrDefault�Լ��� ������ �˾ƾ� �Ѵ�.
			
			//�ʿ� �ƹ��͵� ����.
		}
		
		//for, while
//		for (char ch : s.toCharArray()) {
		
//			if(!map.containsKey(ch)) {	//i�� ó���� ������
				//�ʿ� ����.
//				map.put(ch,1 );
//			}else {
//				map.put(ch, map.get(ch)+1);
//			}
//		}
		

		//3. i =2 ,n=2, f=1 ,l=2.. a=1
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}
}