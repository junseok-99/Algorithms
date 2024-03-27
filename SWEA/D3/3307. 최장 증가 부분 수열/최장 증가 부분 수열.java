import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] dp;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			dp = new int[N];
			nums = new int[N];
			int l = 0;
			int r = -1;
			
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			//N * 이진 탐색
			for (int i = 0; i < N; i++) {
				if (r == -1 || dp[r] < nums[i]) dp[++r] = nums[i];
				else {
					int idx = binarySearch(l, r, nums[i]);
					dp[idx] = nums[i];
				}
			}
			
			sb.append("#").append(tc).append(' ').append(r + 1).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int binarySearch(int l, int r, int n) {
		
		while (l < r) {
			int mid = (l + r) / 2;
			
			if (n <= dp[mid]) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}
}