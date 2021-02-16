import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw5215 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int test_case = 1; test_case<=T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); //재료수
			int L = Integer.parseInt(st.nextToken()); //제한칼로리
			
			int[] calories = new int[N]; //칼로리
			int[] happy = new int[N]; //맛평가
			int[][] dp = new int[N+1][L+1]; //갯수와 누적칼로리
			//L+1을 한 이유는 1000kcal는 [1000]위치에 저장되기 때문에 한칸 더 커야한다.
			//N+1을 한 이유는 아무것도 안뽑은 상태를 표현하기 위해서다.
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				happy[i] = Integer.parseInt(st.nextToken());
				calories[i] =Integer.parseInt(st.nextToken()); 
			}
			
			for(int i = N-1; i>=0; i--) {
				for(int j = 0; j <= L; j++) {//제한 칼로리만큼 반복
					if(j < calories[i])
						dp[i][j] = dp[i+1][j];//해당 칼로리보다 적으면 이 칼로리를 뽑을 수 없기 때문이다.
					else
						//해당 칼로리보다 많으면 이 재료를 안넣은 맛과 이 재료를 넣어서 만들어진 값 중 가장 큰 값을 뽑을 수 있다.
						//그 중 가장 큰값을 답으로 원하므로, 비교해서 가장 큰 걸 넣는다.
						dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j-calories[i]] +happy[i]);
				}
			}
			//다 뽑고 최종적인 칼로리에 저장된 값이 가장 큰 값이다.
			System.out.println("#"+test_case+" "+dp[0][L]);
			
		}
		
	}
}
