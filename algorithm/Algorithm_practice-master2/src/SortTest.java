
import java.util.Arrays;

public class SortTest {
	public static void main(String[] args) {
		int[] arr = {4,2,6,1,8};
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr); // ��������
		System.out.println(Arrays.toString(arr));
		
		String[] srr = {"xds", "atr", "dsj", "ppp"};
		System.out.println(Arrays.toString(srr));
		Arrays.sort(srr);
		System.out.println(Arrays.toString(srr));
		
		Some[] aarr = {new Some("xx",7), new Some("abc", 9), new Some("bbb",5), new Some("ttt", 6)};
		System.out.println(Arrays.toString(aarr));
		Arrays.sort(aarr);
		System.out.println(Arrays.toString(aarr));
	} // end of main
	
	static class Some implements Comparable<Some>{	//���� ����
		//���� ���� ����.
		String s;
		int i;
		double d;
		public Some(String s, int i) {
			this.s = s;
			this.i = i;
		}
		@Override
		public String toString() {
			return "[" + s + "," + i + "]";
		}
		@Override
		public int compareTo(Some o) { // �񱳱����� ���ϱ�		
			return new Integer(this.i).compareTo(o.i); // ��������  this.i - o.i �� ���� i �������� ����
//			return this.s.compareTo(o.s); // �������� this.s - o.s	���Ϸ��°� String���� �ڷ����� �ƴϰ� ��ü��?
//			return o.s.compareTo(this.s); // �������� o.s - this.s	���������� �ݴ��
		}
	}
}