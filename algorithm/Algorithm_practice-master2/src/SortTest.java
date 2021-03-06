
import java.util.Arrays;

public class SortTest {
	public static void main(String[] args) {
		int[] arr = {4,2,6,1,8};
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr); // 오름차순
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
	
	static class Some implements Comparable<Some>{	//정렬 기준
		//정렬 나올 수도.
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
		public int compareTo(Some o) { // 비교기준을 정하기		
			return new Integer(this.i).compareTo(o.i); // 오름차순  this.i - o.i 이 경우는 i 기준으로 정렬
//			return this.s.compareTo(o.s); // 오름차순 this.s - o.s	비교하려는게 String같은 자료형이 아니고 객체면?
//			return o.s.compareTo(this.s); // 내림차순 o.s - this.s	내림차순은 반대로
		}
	}
}
