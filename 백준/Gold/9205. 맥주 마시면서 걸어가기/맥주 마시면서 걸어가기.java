import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<List<Integer>> points;
	static P[] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			points = new ArrayList<>();
			map = new P[n + 2];
			
			for (int i = 0; i < n + 2; i++) {
				points.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			map[0] = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				map[i] = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			map[n + 1] = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			for (int i = 0; i < n + 2; i++) {
				for (int j = 0; j < n + 2; j++) {
					if (i == j) continue;
					if (isGo(i, j)) points.get(i).add(j);
				}
			}
			
			if (bfs(0, n)) sb.append("happy").append("\n");
			else sb.append("sad").append("\n");
		}
		System.out.println(sb);
	}
	
	public static boolean isGo(int s, int d) {
		P p1 = map[s];
		P p2 = map[d];
		int dist = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
		return dist <= 1000;
	}

	public static boolean bfs(int start, int n) {
		Deque<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n + 2];
		visited[start] = true;
		q.add(start);
		
		while (!q.isEmpty()) {
			int num = q.poll();
			
			for (int nei : points.get(num)) {
				if (visited[nei]) continue;
				visited[nei] = true;
				q.add(nei);
			}
		}
		return visited[n + 1];
	}
}

class P {
	int x;
	int y;
	
	P(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
