import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int R;
	static int C;
	static char[][] map;
	static boolean[][][] visited;
	static Deque<P> jQ = new ArrayDeque<>();
	static Deque<P> fQ = new ArrayDeque<>();
	static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[2][R][C];
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'J') {
					jQ.add(new P(i, j));
					visited[0][i][j] = true;
				}
				else if (map[i][j] == 'F') {
					fQ.add(new P(i, j));
					visited[1][i][j] = true;
				}
			}
		}
		
		int answer = bfs();
		if (answer == -1) System.out.println("IMPOSSIBLE");
		else System.out.println(answer);
	}
	
	public static int bfs() {
		int time = 1;
		
		while (!jQ.isEmpty()) {
			int size = jQ.size();
			while (size-- > 0) {
				P p = jQ.poll();
				
				if (map[p.r][p.c] == 'F') continue;
				for (int i = 0; i < 4; i++) {
					int tr = p.r + d[i][0];
					int tc = p.c + d[i][1];
					
					if (invalidRange(tr, tc)) return time;
					if (visited[0][tr][tc] || map[tr][tc] == 'F' || map[tr][tc] == '#') continue;
					visited[0][tr][tc] = true;
					map[tr][tc] = 'J';
					jQ.add(new P(tr, tc));
				}
				map[p.r][p.c] = '.'; 
			}
			fire();
			++time;
		}
		return -1;
	}
	
	public static void fire() {
		int size = fQ.size();
		while (size-- > 0) {
			P p = fQ.poll();
			
			for (int i = 0; i < 4; i++) {
				int tr = p.r + d[i][0];
				int tc = p.c + d[i][1];
				
				if (invalidRange(tr, tc) || visited[1][tr][tc] || map[tr][tc] == '#') continue;
				visited[1][tr][tc] = true;
				map[tr][tc] = 'F';
				fQ.add(new P(tr, tc));
			}
		}
	}
	
	public static boolean invalidRange(int r, int c) {
		return r < 0 || r >= R || c < 0 || c >= C;
	}
}

class P {
	int r;
	int c;
	
	P(int r, int c) {
		this.r = r;
		this.c = c;
	}
}