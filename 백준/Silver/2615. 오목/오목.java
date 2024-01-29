import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] map = new int[20][20];
		int[][] delta = {{-1, 1}, {0, 1}, {1, 1}, {1, 0}};
		
		
		for (int i = 1; i <= 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				if (map[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						int prevR = i - delta[k][0];
						int prevC = j - delta[k][1];
						if (validRange(prevR, prevC) && map[i][j] == map[prevR][prevC]) {
							continue;
						}
						int sameColorCnt = dfs(map, i, j, delta[k][0], delta[k][1], map[i][j], 0);
						if (sameColorCnt == 5) {
							StringBuilder sb = new StringBuilder();
							sb.append(map[i][j] + "\n");
							sb.append(i + " " + j);
							System.out.println(sb.toString());
							return;
						} 
					}
					
				}
			}
		}
		System.out.println(0);
	}
	
	public static int dfs(int[][] map, int y, int x, int dy, int dx, int color, int depth) {
		int tmpColor = map[y][x];
		if (tmpColor != color) {
			return depth;
		}
		
		int ty = y + dy;
		int tx = x + dx;
		if (validRange(ty,tx)) {
			return dfs(map, ty, tx, dy, dx, color, depth + 1);
		}
		
		return depth + 1;
	}
	
	public static boolean validRange(int y, int x) {
		return y >= 1 && y <= 19 && x >= 1 && x <= 19;
	}
}

