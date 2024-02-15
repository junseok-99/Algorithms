import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static boolean[] cols; //행
	static int[][] curQueens; //현재까지 놓여진 퀸의 좌표
	static int N;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		answer = 0;
		N = Integer.parseInt(br.readLine());
		cols = new boolean[N];
		curQueens = new int[N][2]; //0: y, 1: x
			
		dfs(0);
			
		sb.append(answer);
		System.out.println(sb);
	}

	public static void dfs(int depth) { //depth: y
		if (depth == N) {
			++answer;
			return;
		}
		
		//같은 대각선, 열에 놓여있지 않으면 계속 진행
		for (int x = 0; x < N; x++) {
			if (cols[x] || inValidDiagonal(depth, x)) continue;
			cols[x] = true;
			curQueens[depth][0] = depth;
			curQueens[depth][1] = x;
			dfs(depth + 1);
			cols[x] = false;
		}
		
	}
	
	//대각선 체크
	public static boolean inValidDiagonal(int depth, int x) {
		for (int i = 0; i < depth; i++) {
			if (Math.abs(curQueens[i][0] - depth) == Math.abs(curQueens[i][1] - x))
				return true;
		}
		return false;
	}
}