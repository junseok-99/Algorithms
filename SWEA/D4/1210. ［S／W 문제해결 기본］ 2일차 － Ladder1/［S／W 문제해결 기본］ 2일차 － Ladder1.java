import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] map = new int[100][100];
	static boolean[][] visited = new boolean[100][100];
	static int[][] delta = {{0, -1}, {0, 1}, {1, 0}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int x = 0; x < 100; x++) {
				if (map[0][x] == 1) {
					if (dfs(0, x)) {
						sb.append("#" + T + " " + x + "\n");
						break;
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
	
	public static boolean dfs(int y, int x) {
		if (map[y][x] == 2) {
			return true;
		}
		
		for (int i = 0; i < 3; i++) {
			int ty = y + delta[i][0];
			int tx = x + delta[i][1];
			
			if (isValidRange(ty, tx) && map[ty][tx] != 0 && !visited[ty][tx]) {
				visited[y][x] = true;
				boolean flag = dfs(ty, tx);
				visited[y][x] = false;
				return flag;
			}
		}
		return false;
	}
	
	public static boolean isValidRange(int y, int x) {
		return 0 <= x && x < 100 && 0 <= y && y < 100;
	}
}
