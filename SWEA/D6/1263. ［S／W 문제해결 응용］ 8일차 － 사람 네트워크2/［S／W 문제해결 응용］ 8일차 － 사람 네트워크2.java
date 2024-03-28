import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] adjM;
	static int[][] graph;
	static int N;
	static final int INF = 1_000_000_000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 1; tc <= T; tc++) {
			int answer = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			adjM = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int connectedN = Integer.parseInt(st.nextToken());
					if (i == j) continue;
					
					adjM[i][j] = connectedN;
					if (adjM[i][j] == 0) adjM[i][j] = INF;
				}
			}

			floyid();
			
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += (adjM[i][j] == INF ? 0 : adjM[i][j]);
				}
				answer = Math.min(answer, sum);
			}
			sb.append("#").append(tc).append(' ').append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void floyid() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					adjM[j][k] = Math.min(adjM[j][k], adjM[j][i] + adjM[i][k]);
				}
			}
		}
	}
}