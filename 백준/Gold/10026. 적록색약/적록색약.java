import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] map;
	static boolean[][] visited;
	static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		int noBlindness = 0;
		int blindness = 0;
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		//적록색약 X
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j, map[i][j]);
					noBlindness++;
				}
			}
		}
				
		//적록색약 O
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs_2(i, j, map[i][j]);
					blindness++;
				}
			}
		}				
				
		System.out.println(noBlindness + " " + blindness);
	}

	//적록색약 X
	public static void dfs(int y, int x, char color) {
		
		visited[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			int tx = x + d[i][0];
			int ty = y + d[i][1];
			
			if (invalidRange(ty, tx) || visited[ty][tx]) {
				continue;
			}
			
			if (color == map[ty][tx]) {
				dfs(ty, tx, color);
			}
		}
	}
	
	//적록색약 O
	public static void dfs_2(int y, int x, char color) {
		
		visited[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			int tx = x + d[i][0];
			int ty = y + d[i][1];
			
			if (invalidRange(ty, tx) || visited[ty][tx]) {
				continue;
			}
			
			if ((color == 'R' || color == 'G') && (map[ty][tx] != 'B')) {
				dfs_2(ty, tx, color);
			} else if (color == map[ty][tx]) {
				dfs_2(ty, tx, color);
			}
		}
	}
	
	public static boolean invalidRange(int y, int x) {
		return x < 0 || x >= N || y < 0 || y >= N;
	}
}