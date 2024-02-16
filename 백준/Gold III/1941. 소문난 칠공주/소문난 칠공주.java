import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	static char[][] map;
	static int answer;
	static List<Point> pts = new ArrayList<>();
	static int[] idxs = new int[7];
	static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		
		for (int i = 0; i < 5; i++) {
			String line = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = line.charAt(j);
				pts.add(new Point(i, j));
			}
		}

		dfs(0, 0);
		
		System.out.println(answer);
	}
	
	public static void dfs(int idx, int depth) {
		if (depth == 7) {
			int dasom = 0;
			for (int i : idxs) {
				char c = map[pts.get(i).y][pts.get(i).x];
				if (c == 'S') {
					dasom++;
				}
			}
			if (dasom >= 4) {
				bfs();
			}
			return;
		}
		
		for (int i = idx; i < 25; i++) {
			idxs[depth] = i;
			dfs(i + 1, depth + 1);
		}
	}

	public static void bfs() {
		Deque<Point> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[5][5];
		
		for (int i = 0; i < 5; i++) {
			Arrays.fill(visited[i], true);
		}
		
		for (int i : idxs) {
			visited[pts.get(i).y][pts.get(i).x] = false;
		}
		
		Point sp = pts.get(idxs[0]);
		visited[sp.y][sp.x] = true;
		q.add(new Point(sp.y, sp.x));
		int depth = 0;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			depth++;
			
			
			for (int i = 0; i < 4; i++) {
				int ty = p.y + delta[i][0];
				int tx = p.x + delta[i][1];
				
				if (tx < 0 || tx >= 5 || ty < 0 || ty >= 5) {
					continue;
				}
				if (!visited[ty][tx]) {
					visited[ty][tx] = true;
					q.add(new Point(ty, tx));
				}
			}
		}
		
		if (depth == 7) {
			++answer;
		}
	}
}

class Point {
	int x;
	int y;
	Point(int y, int x) {
		this.x = x;
		this.y = y;
	}
}