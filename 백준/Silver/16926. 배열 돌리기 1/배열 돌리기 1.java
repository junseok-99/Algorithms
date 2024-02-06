import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int[][] delta = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int start = Math.min(N, M);
		//배열 돌리기
		while (R > 0) {
			visited = new boolean[N][M];
			for (int i = 0; i < start / 2; i++) {
				dfs(i, i, 0);
			}
			R--;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	//배열의 격자를 방문하며 이전 값 갱신
	public static void dfs(int y, int x, int dir) {
		if (dir == 4) {
			return;
		}
		
		
		int num = map[y][x];
		int ty = y + delta[dir][0];
		int tx = x + delta[dir][1];
		
		if (tx < 0 || tx >= M || ty < 0 || ty >= N || visited[ty][tx]) {
			dir++;
			dfs(y, x, dir);
		} else { 
			dfs(ty, tx, dir);
			map[ty][tx] = num;
			visited[y][x] = true;
		}
	}
}