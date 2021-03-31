package String_Array;


import java.util.HashSet;
import java.util.Set;

public class _07_JewelsAndStones {

	public static void main(String[] args) {
		String J = "aA", S = "aAAbbbb";
		System.out.println(solve(J, S));
	}

	public static int solve(String jew, String stone) {
		//1. ����
		Set<Character> set = new HashSet<>();
		//2.stones �� for�� ����.
		for (char jewel : jew.toCharArray()) {	//�̷��� �ʹ� ���� �����ϱ� �׳� �ܿ�� ���� ����.
			//string�� ��̷� ���� char�� ����
			set.add(jewel); // �ٲ� ������ set�� ����.
		}

		int count = 0;
		for (char stoneChar : stone.toCharArray()) {
			System.out.println("stoneChar: " + stoneChar);
			if (set.contains(stoneChar)) {	//set�� �ִ��� üũ
				count++;
			}
		}
		return count;
	}
}