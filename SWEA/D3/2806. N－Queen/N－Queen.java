import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static boolean[] cols; //행
	static int[][] curQueens;
	static int N;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			cols = new boolean[N];
			curQueens = new int[N][2]; //0: y, 1: x
			
			dfs(0);
			
			sb.append("#").append(tc).append(' ').append(answer).append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int depth) {
		if (depth == N) {
			++answer;
			return;
		}
		
		for (int x = 0; x < N; x++) {
			if (cols[x] || inValidDiagonal(depth, x)) continue;
			cols[x] = true;
			curQueens[depth][0] = depth;
			curQueens[depth][1] = x;
			dfs(depth + 1);
			cols[x] = false;
		}
		
	}
	
	public static boolean inValidDiagonal(int depth, int x) {
		for (int i = 0; i < depth; i++) {
			if (Math.abs(curQueens[i][0] - depth) == Math.abs(curQueens[i][1] - x))
				return true;
		}
		return false;
	}
	
	public static boolean inValidRange(int y, int x) {
		return x < 0 || N <= x || y < 0 || N <= y;
	}
}
