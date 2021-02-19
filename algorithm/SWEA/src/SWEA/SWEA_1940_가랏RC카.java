package SWEA;

//public class SWEA_1940_����RCī {
//
//}
import java.io.*;
import java.util.StringTokenizer;

public class SWEA_1940_����RCī {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int time = Integer.parseInt(br.readLine()); //�ð�
			int rc = 0; //�ӵ�
			int dis = 0; //�Ÿ�
            
			for(int i=0; i<time; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				
				if(command != 0) {
					int accel = Integer.parseInt(st.nextToken()); //���ӵ�
                    
					if(command == 1) { //����
						rc += accel;
					} else { //����
						if(rc < accel) {
							rc = 0;
						} else {
							rc -= accel;
						}
					}
                    
				}
                
				dis += rc;
			}
			System.out.println("#"+tc+" "+dis);
		}
	}

}

//import java.util.Scanner;
//public class SWEA_1940_����RCī {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for(int t=1; t<=T; t++) {
//            int N = sc.nextInt();
//            int a, v = 0, d = 0;
//            for(int n=0; n<N; n++) {
//                int command = sc.nextInt();
//                if( command != 0 ) {
//                    a = sc.nextInt();
//                    if( command == 1 ) v += a;
//                    else {
//                        v -= a;
//                        if( v<0 ) v=0;
//                    }
//                }
//                d += v;
//            }
//            System.out.format( "#%d %d\n", t, d );
//        }
//    }
//}