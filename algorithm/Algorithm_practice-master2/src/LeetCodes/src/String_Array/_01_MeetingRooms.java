package String_Array;

import java.util.Arrays;
import java.util.Comparator;
/*
* Arrays.sort() 
* time complexity of O(n logn n) 
* space complexity of O(1).
*/


//class Interval{
//	int start;
//	int end;
//	Interval(){
//		this.start = 0;
//		this.end =0;
//	}
//	Interval(int s, int e){
//		this.start = s;
//		this.end = e;
//	}
//}
public class _01_MeetingRooms {
	public static void main(String[] args) {
		_01_MeetingRooms a = new _01_MeetingRooms();
		
	
		Interval in1 = new Interval(15,20);
		Interval in2 = new Interval(5,10);
		Interval in3 = new Interval(0,30);
		
		Interval[] intervals = {in1, in2,in3};
		System.out.println(a.solve(intervals));
	}
	
	public boolean solve(Interval[] intervals) {
		if(intervals == null) return false;
		//1 sorting
		print(intervals);
		Arrays.sort(intervals, Comp);	//��ü�� ���� sorting
		//��ü�� �����ض� Comp��
		System.out.println("===after sort====");
		print(intervals);
		
		for(int i=1; i<intervals.length; i++) {
			if(intervals[i-1].end >intervals[i].start)
				//���� ���� endŸ�Ӱ� ���粨�� start ���ؼ� endŸ���� �� ũ�� false
				return false;
		}
			
		return true;
		
		
	}
	public void print(Interval[] intervals) {
		for(int i=0; i<intervals.length; i++) {
			Interval in = intervals[i];
			System.out.println(in.start+" "+in.end);
			
		}
	}
	Comparator<Interval> Comp = new Comparator<Interval>() {
		//�����ϰڴ�.

		@Override
		public int compare(Interval a, Interval b) {
			// TODO Auto-generated method stub
			return a.start - b.start;	//�̷��� �ϸ� ��������
		}
		
	};
	
	

}
