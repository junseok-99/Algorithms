import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int K;
	static int H;
	static int W;
	static boolean[][] map;
	static boolean[][][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new boolean[H][W];
		visited = new boolean[35][H][W];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1) map[i][j] = true;
			}
		}
		
		System.out.println(bfs());
	}

	public static int bfs() {
		Deque<Monkey> q = new ArrayDeque<>();
		q.add(new Monkey(0, 0, 0, 0));
		visited[0][0][0] = true;
		visited[1][0][0] = true;
		int[][] mD = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		int[][] hD = {{-2, -1}, {-1, -2}, {2, -1}, {1, -2}, {-2, 1}, {-1, 2}, {2, 1}, {1, 2}};
		
		while (!q.isEmpty()) {
			Monkey monkey = q.poll();
			
			if (monkey.x == W - 1 && monkey.y == H - 1) {
				return monkey.dist;
			}
			
			for (int i = 0; i < 4; i++) {
				int tx = monkey.x + mD[i][0];
				int ty = monkey.y + mD[i][1];
				
				if (invalidRange(tx, ty) || map[ty][tx] || visited[monkey.k][ty][tx]) continue;
				visited[monkey.k][ty][tx] = true;
				q.add(new Monkey(tx, ty, monkey.dist + 1, monkey.k));
			}
			
			if (monkey.k >= K) continue;
			
			for (int i = 0; i < 8; i++) {
				int tx = monkey.x + hD[i][0];
				int ty = monkey.y + hD[i][1];
				
				if (invalidRange(tx, ty) || map[ty][tx] || visited[monkey.k + 1][ty][tx]) continue;
				visited[monkey.k + 1][ty][tx] = true;
				q.add(new Monkey(tx, ty, monkey.dist + 1, monkey.k + 1));
			}
		}
		return -1;
	}
	
	public static boolean invalidRange(int x, int y) {
		return x < 0 || x >= W || y < 0 || y >= H;
	}
}

class Monkey {
	int x;
	int y;
	int dist;
	int k;
	
	public Monkey(int x, int y, int dist, int k) {
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.k = k;
	}
}