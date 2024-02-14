import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visited;
	static int[][] delta = {{1, -1}, {1, 0}, {1, 1}};
	static int answer = 0;
	static boolean flag = true;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'x') visited[i][j] = true;
			}
		}
		
		for (int i = 0; i < R; i++) {
			flag = true;
			dfs(i, 0);
			
//			for (int j = 0; j < R; j++) {
//				System.out.println(Arrays.toString(visited[j]));
//			}System.out.println();
		}
		
		System.out.println(answer);
	}

	public static void dfs(int y, int x) {
		if (flag && x == C - 1) {
			++answer;
			flag = false;
			visited[y][x] = true;
			return;
		}
		if (!flag) return;
		
		visited[y][x] = true;
		for (int i = 0; i < 3; i++) {
			int tx = x + delta[i][0];
			int ty = y + delta[i][1];
			
			if (tx < 0 || C <= tx || ty < 0 || R <= ty || visited[ty][tx]) continue;
			
			dfs(ty, tx);
		}
	}
}