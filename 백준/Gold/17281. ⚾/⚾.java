import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] innings;
	static boolean[] visited;
	static int[] seq;
	static int cnt = 0;
	static int maxPoint = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		innings = new int[N][9];
		seq = new int[9];
		seq[3] = 1;
		visited = new boolean[10];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				innings[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		permu(0);
		System.out.println(maxPoint);
	}
	
	//야구 게임 시작
	public static void startGame() {
		int inning = 0;
		int out = 0;
		boolean[] rus = new boolean[3]; //0: 1루, 1: 2루, 2: 3루
		int idx = 0;
		int pointSum = 0;
		
		while (inning < N) {
			int result = innings[inning][seq[idx] - 1]; //타자의 결과
			int point = calcPoint(rus, result); //현재 루에 있는 점수 계산
			if (result == 0) { //아웃
				out++;
			} else if (result == 4) { //홈런
				point++;
			} else { //1, 2, 3 루타
				rus[result - 1] = true;
			}
			
			pointSum += point;
			if (out == 3) {
				rus = new boolean[3];
				inning++;
				out = 0;
			}
			idx = (idx + 1) % 9;
		}
		maxPoint = Math.max(maxPoint, pointSum);
	}
	
	public static int calcPoint(boolean[] rus, int ta) {
		if (ta == 0) return 0;
		
		int point = 0;
		for (int i = 2; i >= 0; i--) {
			if (!rus[i]) continue; //루에 주자가 없으면 컨티뉴
			rus[i] = false; //주자가 뛴다.
			if (i + ta >= 3) 
				point++;
			else 
				rus[i + ta] = true; //(i + ta)루에 도착
			
		}
		return point;
	}

	//순서 뽑기
	public static void permu(int depth) {
		if (depth == 8) {
			startGame();
			return;
		}
		
		for (int i = 2; i <= 9; i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			if (depth >= 3) seq[depth + 1] = i;
			else seq[depth] = i;
			permu(depth + 1);
			visited[i] = false;
		}
	}
}