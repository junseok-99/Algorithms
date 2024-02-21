import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static char[][] map;
	static boolean[] visited;
	static int R;
	static int C;
	static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static int max = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[26];
		
		//맵 초기화
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		dfs(0, 0, 1);
		System.out.println(max);
	}
	
	//말 움직이기
	public static void dfs(int y, int x, int depth) {
		max = Math.max(max, depth);
		if (max == 26) {
			return;
		}
		
		int c = map[y][x] - 'A';
		visited[c] = true;
		
		for (int i = 0; i < 4; i++) {
			int tx = x + d[i][0];
			int ty = y + d[i][1];
			
			if (invalidRange(ty, tx)) {
				continue;
			}
			
			c = map[ty][tx] - 'A';
			if (visited[c]) {
				continue;
			}
			dfs(ty, tx, depth + 1);	
			visited[c] = false;
		}
		
	}

	public static boolean invalidRange(int y, int x) {
		return x < 0 || x >= C || y < 0 || y >= R;
	}
}