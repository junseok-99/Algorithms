import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[][] map;
	static int H;
	static int W;
	static Tank tank;
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			
			initMap();
			processUserInput();
			
			sb.append("#").append(tc).append(' ').append(outputMap());
		}

		System.out.println(sb);
	}
	
	public static void processUserInput() throws IOException {
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		
		for (int i = 0; i < N; i++) {
			char c = input.charAt(i);
			
			if (c == 'S') {
				Direction d = castDir();
				tank.shoot(map, H, W, d.y, d.x);
			} else {
				Direction d = new Direction(c);
				tank.move(map, H, W, d.y, d.x, d.dir);
			}
		}
	}

	public static void initMap() throws IOException {
		for (int i = 0; i < H; i++) {
			String s = br.readLine();
			for (int j = 0; j < W; j++) {
				char c = s.charAt(j);
				map[i][j] = c;
				if (c == '>' ||c == '<' ||c == '^' ||c == 'v') {
					tank = new Tank(i, j, c);
				}
			}
		}
	}
	
	public static Direction castDir() {
		if (tank.dir == '^') {
			return new Direction(-1, 0);
		} else if (tank.dir == 'v') {
			return new Direction(1, 0);
		} else if (tank.dir == '<') {
			return new Direction(0, -1);
		} else if (tank.dir == '>') {
			return new Direction(0, 1);
		}
		return null;
	}
	
	public static String outputMap() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < H; i++) {
			sb.append(new String(map[i])).append("\n");
		}
		return sb.toString();
	}
}

class Tank {
	int x;
	int y;
	char dir;
	
	public Tank(int y, int x, char dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public void move(char[][] map, int H, int W, int dy, int dx, char changedDir) {	
		this.dir = changedDir;
		map[this.y][this.x] = this.dir;
		int tx = this.x + dx;
		int ty = this.y + dy;
		if (0 > tx || tx >= W || 0 > ty || ty >= H) return;
		
		if (map[ty][tx] == '.') {
			map[ty][tx] = dir;
			map[this.y][this.x] = '.';
			this.x = tx;
			this.y = ty;
		}
	}
	
	public void shoot(char[][] map, int H, int W, int dy, int dx) {
		int tx = this.x;
		int ty = this.y;
		while (true) {
			tx += dx;
			ty += dy;
			//맵을 벗어나면
			if (0 > tx || tx >= W || 0 > ty || ty >= H) return;
			//벽돌이면
			if (map[ty][tx] == '*') {
				map[ty][tx] = '.';
				return;
			} else if (map[ty][tx] == '#') { //강철이면
				return;
			}
		}
	}
}

class Direction {
	int x;
	int y;
	char dir;
	
	public Direction(int y, int x) {
		this.x = x;
		this.y = y;
	}
	
	public Direction(char dir) {
		if (dir == 'U') {
			this.x = 0;
			this.y = -1;
			this.dir = '^';
		} else if (dir == 'D') {
			this.x = 0;
			this.y = 1;
			this.dir = 'v';
		} else if (dir == 'L') {
			this.x = -1;
			this.y = 0;
			this.dir = '<';
		} else if (dir == 'R') {
			this.x = 1;
			this.y = 0;
			this.dir = '>';
		}
	}
}