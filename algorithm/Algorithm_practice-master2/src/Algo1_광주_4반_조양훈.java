import java.util.*;
public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		
		int M= sc.nextInt();
		String temp;
		String[] arr  = new String[100];
		int i;
		int k=0;
		for( i =N ; i<M; i++) {
			temp =Integer.toString(i);
//			int a = sc.nextInt();
//			char c = (char) ((char)a+65);
//			System.out.println(c); 아스키코드로 어떻게 해보려다가 그냥 포기했습니다..ㅠ
			
			arr[k++] = (Integer.toString(i));
		}
		for( i =0 ; i<M-N; i++) {
			System.out.println(arr[i]);
		}
		
//		Arrays.sort(arr, new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		
//		}
		String str[] = {"eight zero","seven nine","eight asdf","8"};
		Arrays.sort(str);
//				for (int q =0; q<2; q++) {	
//					for(int w=0; w<2;w++) {
//						if(str[q].compareTo(str[w])<0) {
//							temp=str[q];
//							str[q] = str[w];
//							str[w] = temp;
//						}
//					}
//				}	//Arrays.sort 쓰면 되는거 모르고 그냥 삽질했네요..
		for( i =0 ; i<str.length; i++) {
			System.out.println(str[i]);
		}
	}	
}