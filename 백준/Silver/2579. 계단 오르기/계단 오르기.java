import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N + 2];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[2] = arr[0];
		
		for (int i = 3; i < N + 2; i++) {
			dp[i] = Math.max(dp[i - 3] + arr[i - 2] + arr[i - 3], dp[i - 2] + arr[i - 2]);
		}
		
		System.out.println(dp[N + 1]);
	}

}