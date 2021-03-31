package BOJ;

import java.util.Arrays;
import java.util.Collections;


public class ArrayReverseTest {
	public static void test03(String[] args) {
		int[] arr = {50, 20, 10, 30, 40};
		Arrays.sort(arr);

		for(int i=0; i<arr.length; i++) {

			System.out.println(arr[i]);
		}
}

//primitive data type �迭�� Arrays.sort �Լ��� �Է��ϸ� �迭�� ���� �����.
//�ø� �������� (arr) sort �����Ƿ� �Ʒ��� ���� �����.
//10, 20, 30, 40, 50

public static void main(String[] args) {
	Integer[] arr2 = { 4, 2, 1, 5, 3 };

	Arrays.sort(arr2, Collections.reverseOrder());
	for(int i=0; i<arr2.length; i++){

		System.out.println(arr2[i]);
	}

}

//primitive data type �� �ƴ� ��ü�� �迭�� �̿���.
//Collection Ŭ������ reverseOrder() �Լ��� �̿�.
//���ݱ����� �ݴ� order. ��, �ݴ�� sort �ϰڴٴ� �ǹ�. ==> �������� 
//(5, 4, 3, 2, 1 )


public static void main1(String[] args) {

	int[] arr1 = {21,4,19,31,16};
	Arrays.sort(arr1, 2, arr1.length);

	for(int i=0; i<arr1.length; i++) {

			System.out.println(arr1[i]);
		}
	}
}
//primitive data type �迭�� Arrays.sor �Լ��� �Է��ϸ� �迭�� ���� �����.
//�ø� �������� sort �����Ƿ� �Ʒ��� ���� �����.
//Arrays.sort(arr1, 2, arr1.length)  ==> 1��°�� �迭, (2��°, 3��°)�� ������ index ���� ����.
//(21, 4 , 16 , 19, 31)

