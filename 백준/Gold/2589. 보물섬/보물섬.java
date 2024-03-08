import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int L;
	static int R;
	static boolean[][] map;
	static int maxDist = Integer.MIN_VALUE;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new boolean[L][R];
		
		for (int i = 0; i < L; i++) {
			String s = br.readLine();
			for (int j = 0; j < R; j++) {
				if (s.charAt(j) == 'L')
					map[i][j] = true;
			}
		}
		
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < R; j++) {
				if (map[i][j])
					bfs(i, j);
			}
		}
		
		System.out.println(maxDist);
	}

	public static void bfs(int y, int x) {
		Deque<Point> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[L][R];
		visited[y][x] = true;
		q.add(new Point(y, x, 0));
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			maxDist = Math.max(maxDist, p.dist);
			
			for (int i = 0; i < 4; i++) {
				int tx = p.x + d[i][0];
				int ty = p.y + d[i][1];
				
				if (tx < 0 || tx >= R || ty < 0 || ty >= L || visited[ty][tx] || !map[ty][tx])
					continue;
				
				visited[ty][tx] = true;
				q.add(new Point(ty, tx, p.dist + 1));
			}
		}
	}
}

class Point {
	int x;
	int y;
	int dist;
	
	Point(int y, int x, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}