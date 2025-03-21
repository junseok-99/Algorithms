import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[K + 1];
		
		Arrays.fill(dp, 10001);
		
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			for (int j = coins[i]; j <= K; j++) {
				dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
			}
		}
		if (dp[K] == 10001) dp[K] = -1;
		System.out.println(dp[K]);
	}
}