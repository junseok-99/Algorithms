import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		if (isSameColor(0, 0, N)) {
			sb.append(map[0][0]);
		} else {
			compression(0, 0, N);
		}
		System.out.println(sb);
	}
	
	//압축하기
	public static void compression(int y, int x, int N) {
		sb.append("(");
		int r = N / 2;
		
		for (int i = y; i < y + N; i += r) {
			for (int j = x; j < x + N; j += r) {
				if (isSameColor(i, j, r)) sb.append(map[i][j]);
				else {
					compression(i, j, r);
				}
			}
		}
		sb.append(")");
	}
	
	public static boolean isSameColor(int y, int x, int N) {
		char color = map[y][x];
		for (int i = y; i < y + N; i++) {
			for (int j = x; j < x + N; j++) {
				if (color != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}