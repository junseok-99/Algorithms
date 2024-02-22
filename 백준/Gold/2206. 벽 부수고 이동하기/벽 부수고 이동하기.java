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
	static boolean[][][] visited;
	static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		visited = new boolean[2][N][M];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				if (line.charAt(j) == '1') 
					map[i][j] = true;
			}
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		Deque<Unit> q = new ArrayDeque<>();
		q.add(new Unit(0, 0, 1, false));
		visited[0][0][0] = true;
		
		while (!q.isEmpty()) {
			Unit unit = q.poll();
			
			if ((unit.x == M - 1) && (unit.y == N - 1)) {
				return unit.dist;
			}
			
			for (int i = 0; i < 4; i++) {
				int tx = unit.x + d[i][0];
				int ty = unit.y + d[i][1];
				
				if (invalidRange(tx, ty)) {
					continue;
				}
				
				//벽돌이면
				if (map[ty][tx] && !unit.isBreak) {
					visited[1][ty][tx] = true;
					q.add(new Unit(tx, ty, unit.dist + 1, true));
				} else if (!map[ty][tx]){
					if (!unit.isBreak && !visited[0][ty][tx]) {
						q.add(new Unit(tx, ty, unit.dist + 1, false));
						visited[0][ty][tx] = true;
					} else if (unit.isBreak && !visited[1][ty][tx]) {
						q.add(new Unit(tx, ty, unit.dist + 1, true));
					}
						visited[1][ty][tx] = true;
						
				}
				
			}
		}
		return -1;
	}
	
	public static boolean invalidRange(int x, int y) {
		return x < 0 || x >= M || y < 0 || y >= N;
	}
}

class Unit {
	int x;
	int y;
	int dist;
	boolean isBreak;
	
	public Unit(int x, int y, int dist, boolean isBreak) {
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.isBreak = isBreak;
	}
}