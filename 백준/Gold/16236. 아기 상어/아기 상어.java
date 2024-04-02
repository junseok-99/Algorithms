import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static Shark shark;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		int answer = 0;
		
		//입력 초기화
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Shark(j, i, 2, 0);
					map[i][j] = 0;
				}
			}
		}
		
		while (isEatFishes()) {
			PriorityQueue<Fish> pq = bfs();
			Fish fish = pq.poll();
			if (fish == null) break;
			answer += fish.dist;
			map[fish.y][fish.x] = 0;
			shark.eat();
			shark.setPosition(fish);
		}
		System.out.println(answer);
	}
	
	public static PriorityQueue<Fish> bfs() {
		Deque<Fish> q = new ArrayDeque<>();
		PriorityQueue<Fish> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		visited[shark.y][shark.x] = true;
		q.add(new Fish(shark.x, shark.y, shark.size, 0));
		
		while (!q.isEmpty()) {
			Fish fish = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int ty = fish.y + d[i][0];
				int tx = fish.x + d[i][1];
				
				if (invalidRange(tx, ty) || visited[ty][tx]) continue;
				
				visited[ty][tx] = true;
				if (map[ty][tx] <= fish.size) {
					if (map[ty][tx] > 0 && map[ty][tx] < fish.size) pq.add(new Fish(tx, ty, map[ty][tx], fish.dist + 1));
					q.add(new Fish(tx, ty, fish.size, fish.dist + 1));
				}
			}
		}
		return pq;
	}
	
	public static boolean isEatFishes() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] < shark.size && map[i][j] > 0) return true;
			}
		}
		return false;
	}
	
	public static boolean invalidRange(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= N;
	}
}

class Shark {
	int x;
	int y;
	int size;
	int eatenFish;
	
	public Shark(int x, int y, int size, int eatenFish) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.eatenFish = eatenFish;
	}
	
	public void eat() {
		this.eatenFish++;
		if (this.size == eatenFish) {
			++size;
			eatenFish = 0;
		}
	}
	
	public void setPosition(Fish fish) {
		this.x = fish.x;
		this.y = fish.y;
	}
}

class Fish implements Comparable<Fish> {
	int x;
	int y;
	int size;
	int dist;
	
	public Fish(int x, int y, int size, int dist) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.dist = dist;
	}

	@Override
	public int compareTo(Fish o) {
		if (Integer.compare(this.dist, o.dist) == 0) {
			if (Integer.compare(this.y, o.y) == 0) {
				return Integer.compare(this.x, o.x);
			}
			return Integer.compare(this.y, o.y);
		}
		return Integer.compare(this.dist, o.dist);
	}
}

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}