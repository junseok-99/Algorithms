import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int N;
	static int[][] map; //지도
	static boolean[][] visited; //방문여부
	static StringBuilder sb = new StringBuilder();
	//우, 하, 좌, 상
	static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
        	sb.append("#" + tc + "\n");
        	N = Integer.parseInt(br.readLine());
        	
        	map = new int[N][N];
        	visited = new boolean[N][N];
        	
        	dfs(0, 0, 1);
        	outputSnailNumbers();
        }
        System.out.println(sb.toString());
	}
	
	//달팽이 숫자 만들기
	public static void dfs(int y, int x, int num) {
		map[y][x] = num;
		visited[y][x] = true;
		
		//우, 하, 좌, 상 순으로 방문
		for (int i = 0; i < 4; i++) {
			int ty = y + delta[i][0];
			int tx = x + delta[i][1];
			if (invalidRange(ty, tx) || visited[ty][tx]) {
				continue;
			}
			
			dfs(ty, tx, num + 1);
		}
	}
	
	//유효 범위인지
	public static boolean invalidRange(int y, int x) {
		return x < 0 || x >= N || y < 0 || y >= N; 
	}

	//달팽이 숫자 출력
	public static void outputSnailNumbers() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N ; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
	}
}