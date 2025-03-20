import java.io.*;
import java.util.*;

class Main {
	
	static int N;
	static char[][] map;
	static boolean[] visited;
	static int[] picked;
	static List<Point> li;
	static int answer;
	static int[][] d = {{1, 0}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N * N];
		li = new ArrayList<>();
		picked = new int[2];
		answer = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
				li.add(new Point(i, j));
			}
		}
		
		combi(0, 0);
		System.out.println(answer);
	}
	
	public static void combi(int idx, int depth) {
		if (depth == 2) {
			Point p1 = li.get(picked[0]);
			Point p2 = li.get(picked[1]);
			
			if (p1.isSameColor(map, p2) || !p1.isNearPart(p2)) return;
			
			answer = Math.max(answer, searchLongPart(p1, p2));
			return;
		}
		
		for (int i = idx; i < N * N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			picked[depth] = i;
			combi(i + 1, depth + 1);
			visited[i] = false;
		}
	}
	
	public static int searchLongPart(Point p1, Point p2) {
		changeColor(p1, p2);
		int maxCnt = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 2; k++) {
					maxCnt = Math.max(maxCnt, dfs(i, j, k, map[i][j]));
				}
			}
		}
		changeColor(p1, p2);
		return maxCnt;
	}
	
	public static int dfs(int r, int c, int dir, char color) {
		if (invalidRange(r, c) || map[r][c] != color) return 0;
		int cnt = 1;
		return cnt + dfs(r + d[dir][0], c + d[dir][1], dir, color);
	}
	
	public static boolean invalidRange(int tr, int tc) {
		return tr < 0 || tr >= N || tc < 0 || tc >= N;
	}
	
	public static void changeColor(Point p1, Point p2) {
		char tmp = map[p1.r][p1.c];
		map[p1.r][p1.c] = map[p2.r][p2.c];
		map[p2.r][p2.c] = tmp;
	}
}

class Point {
	int r;
	int c;
	
	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
	public boolean isSameColor(char[][] map, Point op) {
		return map[this.r][this.c] == map[op.r][op.c];
	}
	
	public boolean isNearPart(Point op) {
		return (Math.abs(this.r - op.r) + Math.abs(this.c - op.c)) == 1;
	}
}