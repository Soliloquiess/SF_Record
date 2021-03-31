package String_Array;


import java.util.*;

//1
class Interval {
	int start;
	int end;

	Interval(int s, int e) {
		this.start = s;
		this.end = e;
	}
}

public class _05_MergeInterval {

	public static void main(String[] args) {

//			int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
		Interval in1 = new Interval(1, 3);
		Interval in2 = new Interval(2, 6);
		Interval in3 = new Interval(8, 10);
		Interval in4 = new Interval(15, 18);

		List<Interval> intervals = new ArrayList<>();
		intervals.add(in1);
		intervals.add(in2);
		intervals.add(in3);
		intervals.add(in4);
		_05_MergeInterval a = new _05_MergeInterval();
		List<Interval> list = a.merge(intervals);

		System.out.println("----result----");
		a.print(list);
	}

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.isEmpty())
			return intervals;
         
//		type1
		Collections.sort(intervals,(a,b) -> a.start-b.start);	//��������

		Collections.sort(intervals,(a,b) -> b.start-a.start);	//��������
//		type2
//		Collections.sort(intervals, comp2);
		//���� �ƹ��ų� �ٵ� Ÿ�� 1�� �� ���� ����.

		List<Interval> result = new ArrayList<Interval>();
		Interval before = intervals.get(0);
		
		for (int i = 1; i < intervals.size(); i++) {
			Interval current = intervals.get(i);
			if (before.end >= current.start) {	//end�� ũ�� ������.
				//���� end�� ������(Math.max �̿��ؼ� before�� end�� ���� end�� ��ħ.
				before.end = Math.max(current.end, before.end);
			} else {
				result.add(before);

				//��ģ������ before�� result��
				before = current;
				//before�� current ������ ���� ��.
			}
		}

		if (!result.contains(before)) {	//�����ſ�result�� ������ before�� �ֳ�.
			System.out.println("before.end: " + before.end);
			result.add(before);	//result�� ������ �� ����.
			
		}

		return result;
	}

	//type2
	Comparator <Interval> comp = new Comparator<Interval>() {
		public int compare(Interval a, Interval b) {
			// TODO Auto-generated method stub
			return a.start - b.start;
		}
	};

	
	Comparator<Interval> Comp = new Comparator<Interval>() {
		//�����ϰڴ�.

		@Override
		public int compare(Interval a, Interval b) {
			// TODO Auto-generated method stub
			return a.start - b.start;	//�̷��� �ϸ� ��������
		}
		
	};
	
	//type3
	Comparator<Interval> comp2 = new Comparator<Interval>() {
		@Override

		public int compare(Interval o1, Interval o2) {
			if (o1.start > o2.start) {
				return 1;
			} else if (o1.start < o2.start) {
				return -1;
			} else {
				return 0;
			}
		}
	};

	void print(List<Interval> list) {
		for (int i = 0; i < list.size(); i++) {
			Interval in = list.get(i);
			System.out.println(in.start + " " + in.end);
		}
	}

}
