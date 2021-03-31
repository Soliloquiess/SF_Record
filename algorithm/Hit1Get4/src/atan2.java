
import java.util.*;
public class atan2 {
		public static void main(String args[]){
			double x = 45.0;
			double y = 30.0;

			System.out.println( Math.atan2(x, y) );
		}
	
}

//수직 기둥을 기준으로 각도가 나온다고 생각하면 됨
// (5, 5) : 45.0 
// (-5, 5) : -45.0 
//double degree = Math.toDegrees(Math.atan2(x, y));
//import java.util.*;
//
//public class Bakjoon {
//    public static void main(String[] args) {
//            Scanner sc =new Scanner(System.in);
//            int temp=3;            
//            while(temp!=0) {
//                int a=sc.nextInt();
//                int b=sc.nextInt();
//                int c=sc.nextInt();
//                int[] arr= {a,b,c};
//                Arrays.sort(arr);
//                temp=a;
//                if(temp==0) {break;}
//                    else {
//                        if(Math.pow(arr[2], 2)==Math.pow(arr[0], 2)+Math.pow(arr[1], 2)) {
//                            System.out.println("right");
// 
//                        }
//                        else {
//                            System.out.println("wrong");
//            }
//            }
//            }    
//          
//    }
//}
// 



//public class programming_7 {
//	public static void main(String[] args) {
//		int count = 0;
//		for (int a=1; a<100; a++) {
//			for (int b=1; b<100; b++) {
//				for (int c=1; c<100; c++) {
//					if(a*a+b*b == c*c) {
//						count++;
//						System.out.printf("%d, %d, %d\n",a,b,c);
//					}
//				}
//			}
//		}
//		System.out.printf("피타고라스 정의 성립하는 직각삼각형은 %d개 입니다.\n",count);
//	}
//}

