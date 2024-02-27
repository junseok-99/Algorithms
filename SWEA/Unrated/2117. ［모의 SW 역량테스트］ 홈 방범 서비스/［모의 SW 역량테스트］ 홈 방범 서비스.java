import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static boolean[][] map;
	static int N;
	static int M;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new boolean[N][N];
			answer = 1;
			
			//지도 초기화
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());
					if (n == 1) map[i][j] = true;
				}
			}
			
			search();
			
			sb.append("#").append(tc).append(' ').append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void search() {
		int K = 1;
		
		while (K <= 50) {
			boolean isAllProfit = false;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int homeCnt = calcHomeCount(i, j, K);
					boolean isProfit = isProfit(K, homeCnt);
					if (isProfit) {
						answer = Math.max(answer, homeCnt);
					}
					isAllProfit |= isProfit;
				}
			}
//			System.out.println(K);
//			if (!isAllProfit) break; //모든 구역에 대해 손해면
			K++;
		}
	}
	
	public static int calcHomeCount(int y, int x, int K) {
		int xBound = 0;
		int tmp = 1;
		int len = K * 2 - 1;
		int startY = y - K + 1;
		int countSum = 0;
		
		for (int i = 1; i <= len; i++) {
			
			//가운데 점
			if (isHouse(startY, x)) countSum++;
			
			//오른쪽, 왼쪽
			for (int dx = 1; dx <= xBound; dx++) {
				int txR = x + dx;
				int txL = x - dx;
				if (isHouse(startY, txR)) countSum++;
				if (isHouse(startY, txL)) countSum++;
			}
			
			if (i == K) tmp *= -1;
			
			xBound += tmp;
			startY++;
		}
		return countSum;
	}
	
	//집인지
	public static boolean isHouse(int y, int x) {
		return x >= 0 && x < N && y >= 0 && y < N && map[y][x];
	}
	
	//손해를 보지 않는가?
	public static boolean isProfit(int K, int homeCnt) {
		int homeProfit = homeCnt * M;
		int manageProfit = (int) Math.pow(K, 2) + (int) Math.pow(K - 1, 2);
		return homeProfit >= manageProfit;
	}
}