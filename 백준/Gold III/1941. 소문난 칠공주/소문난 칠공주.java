import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Main {

	static char[][] map;
	static int answer;
	static List<Point> pts = new ArrayList<>();
	static int[] idxs = new int[7];
	static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		visited = new boolean[5][5];
		
		for (int i = 0; i < 5; i++) {
			String line = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = line.charAt(j);
				pts.add(new Point(i, j));
			}
		}

		dfs(0, 0, 0);
		
		System.out.println(answer);
	}
	
	public static void dfs(int idx, int depth, int dasom) {
		if (depth == 7) {
			if (dasom >= 4) {
				bfs();
			}
			return;
		}
		
		for (int i = idx; i < 25; i++) {
			idxs[depth] = i;
			int y = pts.get(i).y;
			int x = pts.get(i).x;
			int da = map[y][x] == 'S' ? 1 : 0;
			visited[y][x] = true;
			dfs(i + 1, depth + 1, dasom + da);
			visited[y][x] = false;
		}
	}

	public static void bfs() {
		Deque<Point> q = new ArrayDeque<>();
		boolean[][] v2 = new boolean[5][5];
		
		Point sp = pts.get(idxs[0]);
		v2[sp.y][sp.x] = true;
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
				if (!v2[ty][tx] && visited[ty][tx]) {
					v2[ty][tx] = true;
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