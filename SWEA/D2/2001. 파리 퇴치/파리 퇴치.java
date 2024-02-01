import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N + 1][N + 1];
			int answer = Integer.MIN_VALUE;
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					map[i][j] += (map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1]);
				}
			}
			
			for (int i = M; i <= N; i++) {
				for (int j = M; j <= N; j++) {
					int sum = map[i][j] - map[i][j - M] - map[i - M][j] + map[i - M][j - M];
					answer = Math.max(answer, sum);
				}
			}
			sb.append("#" + tc + " " + answer + "\n");
		}
		
		System.out.println(sb);
	}

}