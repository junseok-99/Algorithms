import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		visited = new boolean[10][10];
		
		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) {
				int n = line.charAt(j) - '0';
				map[i][j] = n;
				if (map[i][j] > 0) visited[i][n] = true;
			}
		}
		dfs(0, 0);
	}
	
	public static void dfs(int y, int x) {
		//찾는 순간 출력 후 바로 종료
		if (y == 9 && x == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		int tx = x + 1 == 9 ? 0 : x + 1;
		int ty = x + 1 == 9 ? y + 1 : y;
		if (map[y][x] > 0) {
			dfs(ty, tx);
		} else {
			int n = -1;
			for (int i = 1; i <= 9; i++) {
				if (!visited[y][i]) n = i;
				map[y][x] = i;
				if (!checkSdoku(x, y)) {
					map[y][x] = 0;
					continue;
				}
				visited[y][i] = true;
				dfs(ty, tx);
				visited[y][i] = false;
				map[y][x] = 0;
			}
			return;
		}
		
	}

	public static boolean checkSdoku(int x, int y) {
		return checkRow(x) && checkCol(y) && checkBox(x, y);
	}
	
	public static boolean checkRow(int x) {
		boolean[] checked = new boolean[10];
		for (int i = 0; i < 9; i++) {
			if (map[i][x] == 0) continue;
			if (checked[map[i][x]]) return false;
			checked[map[i][x]] = true;
		}
		return true;
	}
	
	public static boolean checkCol(int y) {
		boolean[] checked = new boolean[10];
		for (int i = 0; i < 9; i++) {
			if (map[y][i] == 0) continue;
			if (checked[map[y][i]]) return false;
			checked[map[y][i]] = true;
		}
		return true;
	}
	
	public static boolean checkBox(int x, int y) {
		int startY = y / 3 * 3;
		int startX = x / 3 * 3;
		boolean[] checked = new boolean[10];
		for (int i = startY; i < startY + 3; i++) {
			for (int j = startX; j < startX + 3; j++) {
				if (map[i][j] == 0) continue;
				if (checked[map[i][j]]) return false;
				checked[map[i][j]] = true;
			}
		}
		return true;
	}
}