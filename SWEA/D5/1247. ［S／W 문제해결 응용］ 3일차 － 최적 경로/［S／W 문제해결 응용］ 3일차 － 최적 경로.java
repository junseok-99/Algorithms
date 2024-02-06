import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static Point comP;
	static Point homeP;
	static Point[] customers;
	static boolean[] visited;
	static int[] paths;
	static int minDistance;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			minDistance = Integer.MAX_VALUE;
			
			int cX = Integer.parseInt(st.nextToken());
			int cY = Integer.parseInt(st.nextToken());
			comP = new Point(cY, cX);
			
			int hX = Integer.parseInt(st.nextToken());
			int hY = Integer.parseInt(st.nextToken());
			homeP = new Point(hY, hX);
			
			visited = new boolean[N];
			paths = new int[N];
			customers = new Point[N];
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				customers[i] = new Point(y, x);
			}
			
			dfs(0, N);
			
			sb.append("#").append(tc).append(' ').append(minDistance).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int depth, int N) {
		if (depth == N) {
			int dist = comP.calcTwoPointDistance(customers[paths[0]]);
			for (int i = 1; i < N; i++) {
				dist += customers[paths[i - 1]].calcTwoPointDistance(customers[paths[i]]);
				if (dist > minDistance) {
					return;
				}
			}
			dist += customers[paths[N - 1]].calcTwoPointDistance(homeP);
			minDistance = Math.min(minDistance, dist);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			paths[depth] = i;
			dfs(depth + 1, N);
			visited[i] = false;
		}
	}

}

class Point {
	int x;
	int y;
	public Point(int y, int x) {
		this.x = x;
		this.y = y;
	}
	
	public int calcTwoPointDistance(Point p) {
		return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
	}
}