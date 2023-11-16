import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws IOException
	{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());

		for (int test_case=1;test_case<=T;test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] dp = new int[N][N];
			dp[0][0] = 1;
			
			System.out.println("#" + test_case);

			for (int i=0;i<N;i++) {
				if (i < N - 1) {
					for (int j=0;j<=i;j++) {
						dp[i+1][j] += dp[i][j];
						dp[i+1][j+1] += dp[i][j];
					}
				}
				for (int j=0;j<=i;j++) {
					System.out.print(dp[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}