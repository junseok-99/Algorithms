import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int D;
	static boolean[][] map;
	static int maxKillCnt = Integer.MIN_VALUE;
	static int livedEnemy;
	static int[] idxs = new int[3];
	static Archer[] archers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new boolean[N + 1][M];
		archers = new Archer[3];
		
		//지도 초기화
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1) {
					map[i][j] = true;
					++livedEnemy;
				}
			}
		}
		
		//궁수 초기화
		for (int i = 0; i < 3; i++) {
			archers[i] = new Archer(N, D);
		}
		
		combi(0, 0);
		
		System.out.println(maxKillCnt);
	}
	
	//디펜스 게임 시작
	public static void startGame() {
		int copyEnemy = livedEnemy; //현재 생존한 적의 수
		boolean[][] copyMap = new boolean[N + 1][M];
		
		//지도 복사
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, copyMap[i], 0, M);
		}
		
		//가장 가까운 적을 찾아서 죽임
		for (int i = 0; i < N; i++) {
			//찾음
			for (int j = 0; j < 3; j++) {
				bfs(copyMap, archers[j]);				
			}
			
			//죽임
			for (int j = 0; j < 3; j++) {
				if (archers[j].pq.isEmpty()) continue;
				Enemy enemy = archers[j].getEnemy();
				copyMap[enemy.y][enemy.x] = false;
			}
			copyEnemy -= move(copyMap);
		}

		maxKillCnt = Math.max(maxKillCnt, copyEnemy);
	}
	
	//가장 가까운 적 찾기
	public static void bfs(boolean[][] copyMap, Archer archer) {
		Deque<Point> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N + 1][M];
		int[][] d = {{-1, 0}, {1, 0}, {0, -1}};
		 
		q.add(new Point(archer.y, archer.x, 0));
		visited[archer.y][archer.x]= true;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			if (copyMap[p.y][p.x]) {
				archer.addEnemy(p.y, p.x, p.dist);
			}
			
			for (int i = 0; i < 3; i++) {
				int tx = p.x + d[i][0];
				int ty = p.y + d[i][1];
				int tDist = p.dist + 1;
				if (invalidRange(tx, ty)) continue;
				if (archer.d < tDist) continue;
				
				if (!visited[ty][tx]) {
					visited[ty][tx] = true;
					q.add(new Point(ty, tx, tDist));
				}
			}
		}
	}
	
	//성에 궁수를 배치하는 조합
	public static void combi(int idx, int depth) {
		if (depth == 3) {
			//성에 궁수 배치
			for (int i = 0; i < 3; i++) {
				archers[i].setPos(idxs[i]);
				//System.out.println(archers[i].y + ", " + archers[i].x);
			}
			
			startGame();
			return;
		}
		
		for (int i = idx; i < M; i++) {
			idxs[depth] = i;
			combi(i + 1, depth + 1);
		}
	}
	
	//적 이동
	public static int move(boolean[][] copyMap) {
		int liveEnemy = 0;
		
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				if (!copyMap[i][j]) continue;
				
				if (i == N - 1) {
					liveEnemy++;
					copyMap[i][j] = false;
				}
				else {
					copyMap[i + 1][j] = copyMap[i][j];
					copyMap[i][j] = false;
				}
			}
		}
		return liveEnemy;
	}
	
	public static boolean invalidRange(int x, int y) {
		return x < 0 || x >= M || y < 0;
	}
}

class Archer {
	int x;
	int y;
	int d;
	PriorityQueue<Enemy> pq;
	
	Archer(int y, int d) {
		this.y = y;
		this.d = d;
		pq = new PriorityQueue();
	}
	
	public void setPos(int x) {
		this.x = x;
	}
	
	public void addEnemy(int ty, int tx, int dist) {
		pq.add(new Enemy(ty, tx, dist));
	}
	
	public Enemy getEnemy() {
		Enemy enemy = pq.poll();
		pq.clear();
		return enemy;
	}
}

class Enemy implements Comparable<Enemy> {

	int y;
	int x;
	int dist;
	
	public Enemy(int y, int x, int dist) {
		this.y = y;
		this.x = x;
		this.dist = dist;
	}

	@Override
	public int compareTo(Enemy o) {
		if (this.dist == o.dist) {
			return this.x - o.x;
		}
		return this.dist - o.dist;
	}
}

class Point {
	int x;
	int y;
	int dist;
	
	Point(int y, int x, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}