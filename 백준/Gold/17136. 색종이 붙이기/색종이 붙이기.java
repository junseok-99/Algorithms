import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] map;
	static boolean[][] attached;
	static int paper;
	static int[] counts = {5, 5, 5, 5, 5};
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new boolean[10][10];
		attached = new boolean[10][10];
		
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = st.nextToken().charAt(0) == '1' ? true : false;
				if (map[i][j]) ++paper;
			}
		}
		
		if (paper == 0) {
			System.out.println(0);
			return;
		}
		
		dfs(0, 0, 0, 0);
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	
	public static void dfs(int x, int y, int depth, int cnt) {
		if (answer < depth) return;
		
		if (y == 10) {
			answer = Math.min(answer, depth);
			return;
		} else if (x == 10) {
			dfs(0, y + 1, depth, cnt);
		} else if (!attached[y][x] && map[y][x]) {
			for (int i = 0; i < 5; i++) {
				if (!isAttach(x, y, i)) continue;
				counts[i]--;
				attach(x, y, i);
				dfs(x + 1, y, depth + 1, cnt + (int)Math.pow(i + 1, 2));
				detach(x, y, i);
				counts[i]++;
			}
			
		} else {
			dfs(x + 1, y, depth, cnt);
		}
	}
	
	public static void attach(int x, int y, int size) {
		for (int i = y; i <= y + size; i++) {
			for (int j = x; j <= x + size; j++) {
				attached[i][j] = true;
			}
		}
	}
	
	public static void detach(int x, int y, int size) {
		for (int i = y; i <= y + size; i++) {
			for (int j = x; j <= x + size; j++) {
				attached[i][j] = false;
			}
		}
	}
	
	public static boolean isAttach(int x, int y, int size) {
		if (counts[size] == 0) return false;
		for (int i = y; i <= y + size; i++) {
			for (int j = x; j <= x + size; j++) {
				if (invalidRange(j, i) || attached[i][j] || !map[i][j]) return false;
			}
		}
		return true;
	}
	
	public static boolean invalidRange(int x, int y) {
		return x < 0 || x >= 10 || y < 0 || y >= 10;
	}
}