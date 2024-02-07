import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static PriorityQueue<Room> pq;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			pq = new PriorityQueue<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new boolean[N][N];
					bfs(i, j, N);
				}
			}
			
			Room answer = pq.poll();
			sb.append("#").append(tc).append(' ');
			sb.append(answer.roomNum).append(' ').append(answer.dist).append("\n");
		}
		System.out.println(sb);
	}

	public static void bfs(int y, int x, int N) {
		int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		Deque<Room> q = new ArrayDeque<>();
		visited[y][x] = true;
		q.add(new Room(map[y][x], y, x, 1));
		int dist = 1;
		
		while (!q.isEmpty()) {
			Room room = q.poll();
			dist = Math.max(dist, room.dist);
			
			for (int i = 0; i < 4; i++) {
				int tx = room.x + delta[i][1];
				int ty = room.y + delta[i][0];
				
				if (tx < 0 || tx >= N || ty < 0 || ty >= N || visited[ty][tx]) {
					continue;
				}
				
				boolean isMove = (room.roomNum + 1) == map[ty][tx];
				if (isMove) {
					q.add(new Room(map[ty][tx], ty, tx, room.dist + 1));
					visited[ty][tx] = true;
				}
			}
			
		}
		pq.add(new Room(map[y][x], dist));
	}
}

class Room implements Comparable<Room> {

	int roomNum;
	int y;
	int x;
	int dist;
	
	public Room(int roomNum, int y, int x, int dist) {
		this.roomNum = roomNum;
		this.y = y;
		this.x = x;
		this.dist = dist;
	}
	
	public Room(int roomNum, int dist) {
		this.roomNum = roomNum;
		this.dist = dist;
	}
	public String toString() {
		return roomNum + ", " + dist;
	}

	@Override
	public int compareTo(Room o) {
		if (this.dist == o.dist)
			return this.roomNum - o.roomNum;
		return o.dist - this.dist;
	}
	
}