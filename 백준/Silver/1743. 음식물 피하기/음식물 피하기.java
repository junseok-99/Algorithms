import java.io.*;
import java.util.*;

class Main {
	
	static int N;
	static int M;
	static int K;
	static boolean[][] map;
	static boolean[][] visited;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = true; 
		}
		
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (!map[i][j] || visited[i][j]) continue;
				answer = Math.max(answer, dfs(i, j));
			}
		}
		System.out.println(answer);
	}
	
	public static int dfs(int r, int c) {
		if (invalidRange(r, c) || visited[r][c] || !map[r][c]) return 0;
		
		visited[r][c] = true;
		
		int cnt = 1;
		for (int i = 0; i < 4; i++) {
			int tr = r + d[i][0];
			int tc = c + d[i][1];
			
			cnt += dfs(tr, tc);
		}
		return cnt;
	}
	
	public static boolean invalidRange(int tr, int tc) {
		return tr <= 0 || tr > N || tc <= 0 || tc > M;
	}
}