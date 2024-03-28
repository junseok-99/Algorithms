import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static char[][] map;
	static int R;
	static int C;
	static boolean[][][] visited;
	static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[64][R][C];
		
		Minsik minsik = null;
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == '0') minsik = new Minsik(i, j, 0, 0);
			}
		}
		
		System.out.println(bfs(minsik));
	}
	
	public static int bfs(Minsik minsik) {
		Deque<Minsik> q = new ArrayDeque<>();
		visited[minsik.key][minsik.r][minsik.c] = true;
		q.add(minsik);
		
		while (!q.isEmpty()) {
			Minsik m = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int tr = m.r + d[i][0];
				int tc = m.c + d[i][1];
				
				if (invalidRange(tr, tc) || map[tr][tc] == '#') continue;
				if (visited[m.key][tr][tc]) continue;
				
				visited[m.key][tr][tc] = true;
				if (isKey(map[tr][tc])) {
					int key = m.key | (1 << (map[tr][tc] - 'a'));
					q.add(new Minsik(tr, tc, m.dist + 1, key));
				} else if (isDoor(map[tr][tc])) {
					int key = 1 << (map[tr][tc] - 'A');
					if ((m.key & key) != key) continue;
					q.add(new Minsik(tr, tc, m.dist + 1, m.key));
				} else {
					if (map[tr][tc] == '1') return m.dist + 1;
					q.add(new Minsik(tr, tc, m.dist + 1, m.key));
				}	
			}
		}
		return -1;
	}
	
	public static boolean invalidRange(int r, int c) {
		return r < 0 || r >= R || c < 0 || c >= C;
	}
	
	public static boolean isKey(char c) {
		return 'a' <= c && c <= 'f';
	}
	
	public static boolean isDoor(char c) {
		return 'A' <= c && c <= 'F';
	}
}

class Minsik {
	int r;
	int c;
	int key;
	int dist;
	
	public Minsik(int r, int c, int dist, int key) {
		this.r = r;
		this.c = c;
		this.dist = dist;
		this.key = key;
	}
}