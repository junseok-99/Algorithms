import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] dp = new int[N];
			
			for (int i = 0; i < N; i++) {
				dp[i] = Integer.parseInt(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			int[] dp2 = new int[M + 1];
			
			for (int i = 0; i < N; i++) {
				for (int j = 1; j <= M; j++) {
					if (j - dp[i] > 0) {
						dp2[j] += dp2[j - dp[i]];
					} else if (j - dp[i] == 0) {
						dp2[j]++;
					}
				}
			}
			System.out.println(dp2[M]);
		}
	}
}