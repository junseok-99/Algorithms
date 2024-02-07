import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int R;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		//배열 초기화
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//이동 연산 수행
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int rotateNum = Integer.parseInt(st.nextToken());
			switch (rotateNum) {
				case 1:
					rotate1();
					break;
				case 2:
					rotate2();
					break;
				case 3:
					rotate3();
					break;
				case 4:
					rotate4();
					break;
				case 5:
					rotate5();
					break;
				case 6:
					rotate6();
					break;
			}
		}
		
		
		//배열 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	//상하 반전
	public static void rotate1() {
//		int mod = R % 2;
//		if (mod % 2 == 1) {
			int[][] tmp = new int[N][M];
			int idx = 0;
			for (int i = N - 1; i >= 0; i--) {
				tmp[idx++] = Arrays.copyOf(map[i], M);
			}
			map = tmp;
//		}
	}
	
	//좌우 반전
	public static void rotate2() {
//		int mod = R % 2;
		int end = M - 1;
//		if (mod % 2 == 1) {
			int[][] tmp = new int[N][M];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					tmp[j][i] = map[j][end - i];
				}
			}
			map = tmp;
//		}
	}
	
	//우측 90도 회전
	public static void rotate3() {
		int[][] tmp;
		int tmpNum = M;
		M = N;
		N = tmpNum;
				
		tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = map[M - j - 1][i];
			}
		}
	
		map = tmp;
	}
	
	//우측 90도 회전
	public static void rotate4() {
		int[][] tmp;
		int tmpNum = M;
		M = N;
		N = tmpNum;
		
		tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = map[j][N - i - 1];
			}
		}
					
		map = tmp;
	}
	
	//그룹 오른쪽
	public static void rotate5() {
		int midR = N / 2;
		int midC = M / 2;
		int[][] idxs = {{0,0}, {0, midC}, {midR, midC}, {midR, 0}};
		int[][] tmp = new int[N][M];
		
		for (int i = 0; i < 4; i++) {
			int r = idxs[i][0];
			int c = idxs[i][1];
			int tr = idxs[(i + 1) % 4][0];
			int tc = idxs[(i + 1) % 4][1];
			
			for (int j = tr; j < tr + midR; j++) {
				for (int k = tc; k < tc + midC; k++) {
					tmp[j][k] = map[r][c++];
				}
				r++;
				c = idxs[i][1];
			}
		}
		map = tmp;
	}
	
	//그룹 왼쪽
	public static void rotate6() {
		int midR = N / 2;
		int midC = M / 2;
		int[][] idxs = {{0,0}, {midR, 0}, {midR, midC}, {0, midC}};
		int[][] tmp = new int[N][M];
		
		 
		for (int i = 0; i < 4; i++) {
			int r = idxs[i][0];
			int c = idxs[i][1];
			int tr = idxs[(i + 1) % 4][0];
			int tc = idxs[(i + 1) % 4][1];
				
			for (int j = tr; j < tr + midR; j++) {
				for (int k = tc; k < tc + midC; k++) {
					tmp[j][k] = map[r][c++];
				}
				r++;
				c = idxs[i][1];
			}
		}
		map = tmp;
	}
}