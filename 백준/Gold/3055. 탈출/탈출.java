import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int R;
	static int C;
	static char[][] map;
	static Point startP;
	static Deque<Point> waterQ = new ArrayDeque<>();
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		//지도 초기화
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'S') {
					map[i][j] = '.';
					startP = new Point(j, i);
				}
				else if (map[i][j] == '*') waterQ.add(new Point(j, i));
			}
		}
		
		bfs();
		System.out.println("KAKTUS");
	}

	public static void bfs() {
		Deque<Point> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[R][C];
		visited[startP.y][startP.x] = true; 
		q.add(startP);
		int time = 0;
		
		while (!q.isEmpty()) {
			flood();
			int size = q.size();
			while (size-- > 0) {
			Point p = q.poll();
			
			
			for (int i = 0; i < 4; i++) {
				int tx = p.x + d[i][0];
				int ty = p.y + d[i][1];
				
				if (invalidRange(tx, ty) || visited[ty][tx]) continue;
				if (map[ty][tx] == 'D') {
					System.out.println(time + 1);
					System.exit(0);
				}
				
				if (map[ty][tx] == '.') {
					visited[ty][tx] = true;
					q.add(new Point(tx, ty));
				}
			}
			}
			
//			System.out.println(time);
			time++;
		}
	}
	
	public static void flood() {
		int size = waterQ.size();
		
		while (size-- > 0) {
			Point p = waterQ.poll();
			
			for (int i = 0; i < 4; i++) {
				int tx = p.x + d[i][0];
				int ty = p.y + d[i][1];
				
				if (invalidRange(tx, ty) || map[ty][tx] != '.') continue;
				map[ty][tx] = '*';
				waterQ.add(new Point(tx, ty));
				
			}
		}
	}
	
	public static boolean invalidRange(int x, int y) {
		return x < 0 || x >= C || y < 0 || y >=R;
	}
	
	
}

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}