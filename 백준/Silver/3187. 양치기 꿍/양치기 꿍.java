import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	private static char[][] map;
	private static boolean[][] visited;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static int sheep = 0;
	private static int wolf = 0;
	private static int R;
	private static int C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int survivedWolf = 0;
		int survivedSheep = 0;
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && (map[i][j] == 'v' || map[i][j] == 'k')) {
					dfs(i, j);
					if (wolf >= sheep) {
						survivedWolf += wolf;
					} else {
						survivedSheep += sheep;
					}
					wolf = 0;
					sheep = 0;
				}
			}
		}
		
		System.out.println(survivedSheep + " " + survivedWolf);
	}
	
	public static void dfs(int y, int x) {
		if (map[y][x] == 'v') {
			wolf++;
		}
		if (map[y][x] == 'k') {
			sheep++;
		}
		visited[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			int tx = dx[i] + x;
			int ty = dy[i] + y;
			
			if (tx < 0 || tx >= C || ty < 0 || ty >= R) {
				continue;
			}
			if (!visited[ty][tx] && map[ty][tx] != '#') {
				dfs(ty, tx);
			}
		}
	}
}
