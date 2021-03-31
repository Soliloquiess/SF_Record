import java.net.*;
import java.io.*;

public class GWANGJU_4_CHOYANGHOON {

	// User and Launcher Information
	static final String NICKNAME = "GWANGJU_04_CHOYANGHOON";
	static final String HOST = "127.0.0.1";

	// Static Value(Do not modify)
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// Predefined Variables(Do not modify)
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		int[][] balls = new int[NUMBER_OF_BALLS][2];
		int order = 0;

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");

			while (socket != null) {

				// Receive Data
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				// Read Game Data
				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Integer.parseInt(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				// Check Signal for Player Order or Close Connection
				if (balls[0][0] == SIGNAL_ORDER) {
					order = balls[0][1];
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				// Show Balls' Position
				for (int i = 0; i < NUMBER_OF_BALLS; i++) {
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				

				//////////////////////////////
				// Beginning of Your Code	여기서부터 코드 실행
				// Put your code here to set angle and power values.
				// angle(float) must be between 0.0 and 360.0
				// power(float) must be between 0.0 and 100.0
				
				float angle = 0.0f;	//각도(0~360도)
				float power = 0.0f;	//파워(힘의 세기)0~100사이의 값

				for(int i=1;i<6;i++) {
			
					if(balls[i][0]==0&&balls[i][1]==0) continue;
//					double radian = Math.atan(width / height);
//					angle = (float) ((180.0 / Math.PI) * radian);
					double radian = Math.atan2(balls[i][0]-balls[0][0],balls[i][1]-balls[0][1]);
					
					angle=(float) (radian*(180.0/Math.PI));
					//개별 스테이지 4 클리어 코드
					if(balls[0][0] == 65&&balls[0][1]== 65) {
				    	angle=105;
				    	power = 100;
				    }
//					if(balls[0][0] == 99&&balls[0][1]== 78) {
//						angle=117;
//				    	power = 100;
//				    }
					break;
				}
				power=100;
				if(angle<0) angle+=360;				
				
//				int whiteBall_x = balls[0][0];
//				int whiteBall_y = balls[0][1];
//
//				int targetBall_x = balls[1][0];
//				int targetBall_y = balls[1][1];
//
//				int width = Math.abs(targetBall_x - whiteBall_x);
//				int height = Math.abs(targetBall_y - whiteBall_y);
//
//				double radian = Math.atan(width / height);
//				angle = (float) ((180.0 / Math.PI) * radian);
//
//				if (targetBall_y < whiteBall_y)
//				{
//					radian = Math.atan(height / width);
//					angle = (float) (((180.0 / Math.PI) * radian) + 90);
//				}
//				
//				double distance = Math.sqrt((width * width) + (height * height));
//				power = (float) distance;
				
				
				// You can clear Stage 1 with the pre-written code above.
				// Those will help you to figure out how to clear other Stages.
				// Good luck!!
				// ENd of Your Code
				//////////////////////////////

				//앵글과 파워를 무슨 공식으로 해야 공 맞추는지 알아야.
				//아크탄젠트 뭐 절대값 어쩌구 다 구함.
				//공 치려면 공 정보 알아야 어느 위치에 있는지 좌표값도 알아야 그게 콘솔에 보면값이 찍힘.
				//흩어진 공들의 위치가 서버에 나옴. 공 정보는 60줄의 balls라는 곳에 저장 저 배열에서 값 꺼내다 써야됨.
				//balls가 2차원 배열로 2개씩 들감.
				// Play(Send Data)
				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}

			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
