import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int M;
	static int N;
	static int[][] map;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static Deque<Point> ripeTomatoQ = new ArrayDeque<>();
	static boolean[][] visited;
	static int rawTomato;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					ripeTomatoQ.add(new Point(i, j));
					visited[i][j] = true;
				} else if (map[i][j] == 0) {
					rawTomato++;
				}
			}
		}
		
		int answer = bfs();
		if (rawTomato > 0) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	//토마토 익히기
	public static int bfs() {
		
		int day = -1;
		
		while (!ripeTomatoQ.isEmpty()) {
			int size = ripeTomatoQ.size();
			while (size-- > 0) {
				Point p = ripeTomatoQ.poll();
				
				for (int i = 0; i < 4; i++) {
					int ty = p.y + d[i][0];
					int tx = p.x + d[i][1];
					
					if (tx < 0 || tx >= M || ty < 0 || ty >= N || visited[ty][tx]) {
						continue;
					}
					if (map[ty][tx] == 0) {
						--rawTomato;
						visited[ty][tx] = true;
						map[ty][tx] = 1;
						ripeTomatoQ.add(new Point(ty, tx));
					}
				}
			}	
			++day;
		}
		return day;
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