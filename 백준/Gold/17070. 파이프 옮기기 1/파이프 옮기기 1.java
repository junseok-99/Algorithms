import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static int[][][] dp;
	static int[][] delta = {{0, 1}, {1, 1}, {1, 0}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//0: 가로, 1: 대각, 2: 세로
		dp = new int[3][N][N];
		dp[0][0][1] = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 3; k++) {
					if (dp[k][i][j] > 0) {
						for (int d = 0; d < 3; d++) {
							//가로일 때 세로는 패스
							if (k == 0 && d == 2) continue;
							//세로일 때 가로는 패스
							if (k == 2 && d == 0) continue;
							
							//대각선일 때 놓을 수 있는지?
							if (d == 1) {
								if ((!invalidRange(j, i + 1) && map[i + 1][j] == 1) ||
										(!invalidRange(j + 1, i + 1) && map[i + 1][j + 1] == 1) ||
										(!invalidRange(j + 1, i) && map[i][j + 1] == 1)
										) continue;
							}
							int tr = i + delta[d][0];
							int tc = j + delta[d][1];
							if (invalidRange(tc, tr) || map[tr][tc] == 1) continue;
							
							dp[d][tr][tc] += dp[k][i][j];
						}
					}
				}
			}
		}
		System.out.println(dp[0][N - 1][N - 1] + dp[1][N - 1][N - 1] + dp[2][N - 1][N - 1]);
	}
	
	public static boolean invalidRange(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= N;
	}
}