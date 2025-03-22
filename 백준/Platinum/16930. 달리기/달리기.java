import java.io.*;
import java.util.*;

class Main {
	
	static int N;
	static int M;
	static int K;
	static char[][] map;
	static int[][] visited;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new int[N][M];
		
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			Arrays.fill(visited[i], Integer.MAX_VALUE);
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		Point startP = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
		Point endP = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
//		System.out.println(bfs(startP, endP));
		bfs(startP, endP);
		System.out.println(visited[endP.r][endP.c] == Integer.MAX_VALUE ? -1 : visited[endP.r][endP.c]);
	}
	
	public static int bfs(Point startP, Point endP) {
		Deque<Point> q = new ArrayDeque<>();
		q.add(startP);
		visited[startP.r][startP.c] = 0;
		
		while (!q.isEmpty()) {
			Point p = q.poll();			
			
			for (int i = 0; i < 4; i++) {
				for (int k = 1; k <= K; k++) {
					int tr = p.r + d[i][0] * k;
					int tc = p.c + d[i][1] * k;
					
					if (invalidRange(tr, tc) || map[tr][tc] == '#') break;
					if (visited[tr][tc] < visited[p.r][p.c] + 1 ) break;
					if (visited[tr][tc] != Integer.MAX_VALUE) continue;
					
					Point nextP = new Point(tr, tc);
					
					q.add(nextP);
					visited[tr][tc] = visited[p.r][p.c]+ 1;
					if (endP.isSamePoint(nextP)) return visited[p.r][p.c]+ 1;
				}
			}
		}
		return -1;
	}
	
	public static boolean invalidRange(int tr, int tc) {
		return tr < 0 || tr >= N || tc < 0 || tc >= M;
	}
}

class Point {
	int r;
	int c;
	int d;
	
	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
	public Point(int r, int c, int d) {
		this.r = r;
		this.c = c;
		this.d = d;
	}
	
	public boolean isSamePoint(Point op) {
		return this.r == op.r && this.c == op.c;
	}
}