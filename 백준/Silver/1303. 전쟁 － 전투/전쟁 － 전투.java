import java.io.*;
import java.util.*;

class Main {
	
	static int N;
	static int M;
	static char[][] map;
	static boolean[][] visited;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		int W = 0;
		int B = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j]) continue;
				if (map[i][j] == 'W') W += Math.pow(dfs(i, j, map[i][j]), 2);
				else if (map[i][j] == 'B') B += Math.pow(dfs(i, j, map[i][j]), 2);
			}
		}
		System.out.println(W + " " + B);
	}
	
	public static int dfs(int r, int c, int color) {
		if (invalidRange(r, c) || visited[r][c] || map[r][c] != color) return 0;
		
		visited[r][c] = true;
		
		int cnt = 1;
		for (int i = 0; i < 4; i++) {
			int tr = r + d[i][0];
			int tc = c + d[i][1];
			
			cnt += dfs(tr, tc, color);
		}
		return cnt;
	}
	
	public static boolean invalidRange(int tr, int tc) {
		return tr < 0 || tr >= N || tc < 0 || tc >= M;
	}
}