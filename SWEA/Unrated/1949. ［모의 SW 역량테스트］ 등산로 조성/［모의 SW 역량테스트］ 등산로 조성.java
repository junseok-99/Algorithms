import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int answer;
	static int N;
	static int K;
	static int[][] map;
	static boolean[][] visited;
	static List<Point> highList;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 1; tc <= T; tc++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N][N];
			highList = new ArrayList<>();
			
			int maxHigh = -1;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if (map[i][j] >= maxHigh) {
						if (map[i][j] > maxHigh) {
							maxHigh = map[i][j];
							highList.clear();
						}
						highList.add(new Point(j, i));
					}
				}
			}
			
			for (Point p : highList) {
				visited[p.y][p.x] = true;
				dfs(p.y, p.x, false, 1);
				visited[p.y][p.x] = false;
			}
			sb.append("#").append(tc).append(' ').append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int y, int x, boolean flag, int depth) {
		answer = Math.max(answer, depth);
		int height = map[y][x];
		for (int i = 0; i < 4; i++) {
			int tx = x + d[i][0];
			int ty = y + d[i][1];
			
			if (invalidRange(tx, ty)) continue;
			if (visited[ty][tx]) continue;
			
			for (int k = 1; k <= K && !flag; k++) {
				if (map[ty][tx] - k >= height) continue;
				map[ty][tx] -= k;
				visited[ty][tx] = true;
				dfs(ty, tx, true, depth + 1);
				visited[ty][tx] = false;
				map[ty][tx] += k;
			}
			if (map[ty][tx] >= height) continue;
			visited[ty][tx] = true;
			dfs(ty, tx, flag, depth + 1);
			visited[ty][tx] = false;
		}
	}
	
	public static boolean invalidRange(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= N;
	}
}

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}