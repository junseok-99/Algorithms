import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static boolean[] isSelected;
	static int answer = Integer.MAX_VALUE;
	static boolean[][] checks;
	static int curSongCnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isSelected = new boolean[N];
		checks = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String code = st.nextToken();
			for (int j = 0; j < M; j++) {
				if (code.charAt(j) == 'Y') checks[i][j] = true;
			}
		}
		
		subSet(0);
		System.out.println(answer == 0 ? -1 : answer);
	}
	
	public static void subSet(int depth) {
		if (depth == N) {
			boolean[] isPossibles = new boolean[M];
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					++cnt;
					for (int j = 0; j < M; j++) {
						isPossibles[j] |= checks[i][j];
					}
				}
			}
			int songCnt = 0;
			for (int i = 0; i < M; i++) {
				if (isPossibles[i]) songCnt++;
			}
			if (curSongCnt <= songCnt) {
				answer = Math.min(answer, cnt);
				curSongCnt = songCnt;
			}
			return;
		}
		
		isSelected[depth] = true;
		subSet(depth + 1);
		isSelected[depth] = false;
		subSet(depth + 1);
	}
}