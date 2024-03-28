import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R;
	static int C;
	static char[][] map;
	static int startR;
	static int startC;
	static int blankR;
	static int blankC;
	static char answer;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; //상, 우, 하, 좌
	static char[] blocks = {'|', '-', '+', '1', '2', '3', '4'};
	static boolean flag = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'M') {
					startR = i;
					startC = j;
				}
			}
		}
		
		//시작점에서 사방 탐색
		for (int i = 0; i < 4; i++) {
			int tr = startR + d[i][0];
			int tc = startC + d[i][1];
			if (invalidRange(tr, tc) || map[tr][tc] == '.' || map[tr][tc] == 'Z') continue;
			search(startR, startC, i);
		}
	}
	
	public static boolean isIn(int dir, char block) {
		switch (block) {
		case '|':
			if (dir == 0 || dir == 2) return true; 
			break;
		case '-':
			if (dir == 1 || dir == 3) return true;
			break;
		case '+':
			return true;
		case '1':
			if (dir == 0 || dir == 3) return true;
			break;
		case '2':
			if (dir == 2 || dir == 3) return true;
			break;
		case '3':
			if (dir == 2 || dir == 1) return true;
			break;
		case '4':
			if (dir == 1 || dir == 0) return true;
			break;
		default:
			return true;
		}
		return false;
	}
	
	public static int changeDir(int dir, char block) {
		switch (block) {
		case '1':
			if (dir == 3) dir = 2;
			else if (dir == 0) dir = 1;
			break;
		case '2':
			if (dir == 3) dir = 0;
			else if (dir == 2) dir = 1;
			break;
		case '3':
			if (dir == 1) dir = 0;
			else if (dir == 2) dir = 3;
			break;
		case '4':
			if (dir == 1) dir = 2;
			else if (dir == 0) dir = 3;
			break;
		}
		return dir;
	}
	
	public static void search(int r, int c, int dir) {
		if (map[r][c] == 'Z') {
			System.out.println((blankR + 1) + " " + (blankC + 1) + " " + map[blankR][blankC]);
			System.exit(0);
		}
		
		int tr = r + d[dir][0];
		int tc = c + d[dir][1];
		if (invalidRange(tr, tc)) return;
		char block = map[tr][tc];
		
		if (!isIn(dir, block)) return;
		
		//해커가 지운것
		if (block == '.') {
			if (flag) return;
			flag = true;
			blankR = tr;
			blankC = tc;
			for (char bc : blocks) {
				if (!isIn(dir, bc)) continue;
				int tmpDir = changeDir(dir, bc);
				map[tr][tc] = bc;
				search(tr, tc, tmpDir);
			}
		} else if ('1' <= block && block <= '4') {
			dir = changeDir(dir, block);
		}
		search(tr, tc, dir);
	}
	
	public static boolean invalidRange(int r, int c) {
		return r < 0 || r >= R || c < 0 || c >= C;
	}
}