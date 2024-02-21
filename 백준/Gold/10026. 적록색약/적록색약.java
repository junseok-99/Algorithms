import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

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
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j, map[i][j]);
					noBlindness++;
				}
			}
		}
		
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs_2(i, j, map[i][j]);
					blindness++;
				}
			}
		}
		
		System.out.println(noBlindness + " " + blindness);
	}

	//적록색약 X
	public static void bfs(int y, int x, char color) {
		Deque<Point> q = new ArrayDeque<>();
		visited[y][x] = true;
		q.add(new Point(y, x, color));
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int tx = p.x + d[i][0];
				int ty = p.y + d[i][1];
				
				if (invalidRange(ty, tx) || visited[ty][tx]) {
					continue;
				}
				
				if (p.color == map[ty][tx]) {
					q.add(new Point(ty, tx, p.color));
					visited[ty][tx] = true;
				}
			}
		}
	}
	
	//적록색약 O
	public static void bfs_2(int y, int x, char color) {
		Deque<Point> q = new ArrayDeque<>();
		visited[y][x] = true;
		q.add(new Point(y, x, color));
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int tx = p.x + d[i][0];
				int ty = p.y + d[i][1];
				
				if (invalidRange(ty, tx) || visited[ty][tx]) {
					continue;
				}
				
				if ((p.color == 'R' || p.color == 'G') && (map[ty][tx] != 'B')) {
					q.add(new Point(ty, tx, p.color));
					visited[ty][tx] = true;
				} else if (p.color == map[ty][tx]) {
					q.add(new Point(ty, tx, p.color));
					visited[ty][tx] = true;
				}
			}
		}
	}
	
	public static boolean invalidRange(int y, int x) {
		return x < 0 || x >= N || y < 0 || y >= N;
	}
}

class Point {
	int x; 
	int y;
	char color;
	
	Point(int y, int x, char color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
}