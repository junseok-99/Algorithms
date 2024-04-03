import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int R;
	static int C;
	static int T;
	static int[][] map;
	static int airR1 = -1;
	static int airR2 = -1;
	static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == -1) {
					if (airR1 == -1) airR1 = i;
					else if (airR2 == -1) airR2 = i;
					map[i][j] = 0;
				}
			}
		}
		
		while (T-- > 0) {
			spread();

			moveDustUp(1, airR1, 1);
			map[airR1][0] = 0;
			
			moveDustDown(1, airR2, 1);
			map[airR2][0] = 0;
		}
		calcRemainDust();
	}
	
	public static void moveDustUp(int x, int y, int dir) {
		if (airR1 == y && x == 0) return;
		
		
		int curDust = map[y][x];
		int tx = x + d[dir][0];
		int ty = y + d[dir][1];
		if (invalidRange(tx, ty)) {
			if (dir == 1) dir = 3;
			else if (dir == 3) dir = 0;
			else if (dir == 0) dir = 2;
			tx = x + d[dir][0];
			ty = y + d[dir][1];
		}
		moveDustUp(tx, ty, dir);
		map[ty][tx] = curDust;
		map[y][x] = 0;
	}
	
	public static void moveDustDown(int x, int y, int dir) {
		if (airR2 == y && x == 0) return;
		
		int curDust = map[y][x];
		int tx = x + d[dir][0];
		int ty = y + d[dir][1];
		if (invalidRange(tx, ty)) {
			if (dir == 1) dir = 2;
			else if (dir == 2) dir = 0;
			else if (dir == 0) dir = 3;
			tx = x + d[dir][0];
			ty = y + d[dir][1];
		}
		moveDustDown(tx, ty, dir);
		map[ty][tx] = curDust;
		map[y][x] = 0;
	}
	
	public static void spread() {
		int[][] copyMap = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					int findDust = map[i][j];
					int spreadDust = findDust / 5;
					int possibleDir = 0;
					
					for (int k = 0; k < 4; k++) {
						int tx = j + d[k][0];
						int ty = i + d[k][1];
						if (invalidRange(tx, ty) || (ty == airR1 && tx == 0) || (ty == airR2 && tx == 0)) continue;
						possibleDir++;
						copyMap[ty][tx] += spreadDust;
					}
					copyMap[i][j] += (map[i][j] - spreadDust * possibleDir);
				}
			}
		}
		map = copyMap;
	}
	
	public static void calcRemainDust() {
		int answer = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) answer += map[i][j];
			}
		}
		System.out.println(answer);
	}
	
	public static boolean invalidRange(int x, int y) {
		return x < 0 || x >= C || y < 0 || y >= R;
	}
}