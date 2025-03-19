import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][M + 1];
		int[][] dp = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//1. First Line
		for (int i = 0; i < M; i++) {
			dp[1][i + 1] = dp[1][i] + map[1][i + 1];
		}
		
		//2. After Line
		for (int i = 2; i <= N; i++) {
			int[] tmpL = new int[M + 2];
			int[] tmpR = new int[M + 2];
			
			tmpL[0] = N * M * -100 + 1;
			tmpR[M + 1] = N * M * -100 + 1;
			
			//Under -> Left
			for (int j = 1; j <= M; j++) {
				tmpL[j] = Math.max(dp[i - 1][j] + map[i][j], tmpL[j - 1] + map[i][j]);
			}
			//Under -> Right
			for (int j = M; j > 0; j--) {
				tmpR[j] = Math.max(dp[i - 1][j] + map[i][j], tmpR[j + 1] + map[i][j]);
			}
			
			//Init Max Value
			for (int j = 1; j <= M; j++) {
				dp[i][j] = Math.max(tmpL[j], tmpR[j]);
			}
		}
		System.out.println(dp[N][M]);
	}
}