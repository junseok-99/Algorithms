import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static boolean[][] map;
	static boolean[][] visited;
	static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		
		//지도 초기화
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int cheese = Integer.parseInt(st.nextToken());
				if (cheese == 1) {
					map[i][j] = true;
				}
			}
		}
		
		
		int hour = 1;
		int prev = calcCheese();
		while (true) {
			visited = new boolean[N][M];
			boolean[][] outlier = bfs();
			melt(outlier);
			int curCheese = calcCheese();
			if (curCheese == 0) {
				break;
			}
			prev = curCheese;
			hour++;
		}
		System.out.println(hour);
		System.out.println(prev);
	}

	//공기와 접촉하는 치즈 찾기
	public static boolean[][] bfs() {
		Deque<Point> q = new ArrayDeque<>();
		q.add(new Point(0, 0));
		visited[0][0] = true;
		boolean[][] tmpMap = new boolean[N][M];
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int tx = p.x + d[i][0];
				int ty = p.y + d[i][1];
				
				if (invalidRange(ty, tx) || visited[ty][tx]) {
					continue;
				}
				
				visited[ty][tx] = true;
				if (map[ty][tx]) {
					tmpMap[ty][tx] = true;
					
				} else if (!map[ty][tx]) {
					q.add(new Point(ty, tx));
				}
			}
		}
		return tmpMap;
	}
	
	public static void melt(boolean[][] outlier) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (outlier[i][j]) {
					map[i][j] = false;
				}
			}
		}
	}
	
	public static int calcCheese() {
		int cheese = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j]) {
					cheese++;
				}
			}
		}
		return cheese;
	}
	
	public static boolean invalidRange(int y, int x) {
		return x < 0 || x >= M || y < 0 || y >= N;
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