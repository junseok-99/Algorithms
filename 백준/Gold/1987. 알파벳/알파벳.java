import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static char[][] map;
	static boolean[][] visited;
	static int R;
	static int C;
	static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static int max = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		
		//맵 초기화
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
//		System.out.println(bfs());
		dfs(0, 0, 0, "");
		System.out.println(max);
	}
	
	public static void dfs(int y, int x, int depth, String s) {
		
		if (s.contains(map[y][x] + "")) {
			max = Math.max(max, depth);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int tx = x + d[i][0];
			int ty = y + d[i][1];
			
			if (invalidRange(ty, tx)) {
				continue;
			}
			

			dfs(ty, tx, depth + 1, s + map[y][x]);
			
		}
	}
	
	//말 움직이기
//	public static int bfs() {
//		Deque<Point> q = new ArrayDeque<>();
//		
//		int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
//		Point sp = new Point(0, 0, 1, new HashSet<>());
//		sp.add(map[0][0]);
//		q.add(sp);
//		int max = 1;
//		
//		while (!q.isEmpty()) {
//			Point p = q.poll();
//			
//			max = Math.max(max, p.depth);
//			
//			for (int i = 0; i < 4; i++) {
//				int tx = p.x + d[i][0];
//				int ty = p.y + d[i][1];
//				
//				if (invalidRange(ty, tx)) {
//					continue;
//				}
//				
//				char c = map[ty][tx];
//				if (!p.contains(c)) { //현재 알파벳을 지나오지 않았다면
//					Set<Character> copySet = p.copySet();
//					copySet.add(c);
//					q.add(new Point(ty, tx, p.depth + 1, copySet));
//				}
//			}
//		}
//		return max;
//	}

	public static boolean invalidRange(int y, int x) {
		return x < 0 || x >= C || y < 0 || y >= R;
	}
}

class Point {
	Set<Character> set = new HashSet<>();
	int x;
	int y;
	int depth;
	
	Point(int y, int x, int depth, Set<Character> set) {
		this.x = x;
		this.y = y;
		this.depth = depth;
		this.set = set;
	}
	
	public boolean contains(char c) {
		return set.contains(c);
	}
	
	public void add(char c) {
		set.add(c);
	}
	
	public Set<Character> copySet() {
		Set<Character> tmp = new HashSet<>();
		tmp.addAll(set);
		return tmp;
	}
}