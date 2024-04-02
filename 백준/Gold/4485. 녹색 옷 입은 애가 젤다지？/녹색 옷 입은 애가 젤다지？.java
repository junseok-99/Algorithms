import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int cnt = 1;
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			
			map = new int[N][N];
			answer = Integer.MAX_VALUE;
			
			//맵 초기화
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs(N);
			sb.append("Problem " + cnt++ + ": ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void bfs(int N) {
		PriorityQueue<Link> q = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		q.add(new Link(0, 0, map[0][0]));
		int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		
		while (!q.isEmpty()) {
			Link l = q.poll();
			
			visited[l.y][l.x] = true;
			
			for (int i = 0; i < 4; i++) {
				int tx = l.x + d[i][0];
				int ty = l.y + d[i][1];
				
				if (invalidRange(tx, ty, N) || visited[ty][tx]) continue;
				
				if (ty == N - 1 && tx == N - 1) answer = Math.min(answer, l.roopy + map[ty][tx]);
				else q.add(new Link(ty, tx, l.roopy + map[ty][tx]));
			}
		}
	}
	
	public static boolean invalidRange(int x, int y, int N) {
		return x < 0 || x >= N || y < 0 || y >= N;
	}
}

class Link implements Comparable<Link> {
	int y;
	int x;
	int roopy;
	
	public Link(int y, int x, int roopy) {
		this.y = y;
		this.x = x;
		this.roopy = roopy;
	}

	@Override
	public int compareTo(Link o) {
		return Integer.compare(this.roopy, o.roopy);
	}
}