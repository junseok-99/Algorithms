import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int M;
	static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static List<Point> zeroList = new ArrayList<>();
	static int[] idxs = new int[3];
	static int maxSafeZone = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		//지도 초기화
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) { //빈 칸이면 리스트에 추가
					zeroList.add(new Point(i, j));
				}
			}
		}
		
		combi(0, 0);
		
		System.out.println(maxSafeZone);
	}

	//x개의 빈 칸 중 3개를 벽으로 만드는 경우의 수
	public static void combi(int idx, int depth) {
		//3개를 벽으로 만듬
		if (depth == 3) {
			for (int i = 0; i < 3; i++) { //벽 세우기
				Point p = zeroList.get(idxs[i]);
				map[p.y][p.x] = 1;
			}
			visited = new boolean[N][M];
			
			virus(); //바이러스 퍼트림
			calcSafeZone(); //안전구역 세기
			
			for (int i = 0; i < 3; i++) { //벽 다시 부수기
				Point p = zeroList.get(idxs[i]);
				map[p.y][p.x] = 0;
			}
			return;
		}
		
		//3개의 빈 칸을 고름
		for (int i = idx; i < zeroList.size(); i++) {
			idxs[depth] = i;
			combi(i + 1, depth + 1);
		}
	}
	
	//바이러스 퍼트림
	public static void virus() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 2) {
					bfs(i, j);
				}
			}
		}
	}
	
	//바이러스 퍼트림
	public static void bfs(int y, int x) {
		Deque<Point> q = new ArrayDeque<>();
		visited[y][x] = true;
		q.add(new Point(y, x));
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int tx = p.x + d[i][0];
				int ty = p.y + d[i][1];
				
				if (invalidRange(ty, tx) || visited[ty][tx]) {
					continue;
				}
				
				if (map[ty][tx] != 1) { //벽이 아니면
					q.add(new Point(ty, tx));
					visited[ty][tx] = true;
				}
			}
		}
	}
	
	//안전지대 세기
	public static void calcSafeZone() {
		int zone = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 0) {
					++zone;
				}
			}
		}
		maxSafeZone = Math.max(maxSafeZone, zone);
	}
	
	public static boolean invalidRange(int y, int x) {
		return x < 0 || x >= M || y < 0 || y >= N;
	}
}

class Point {
	int x;
	int y;
	
	Point (int y, int x) {
		this.x = x;
		this.y = y;
	}
}