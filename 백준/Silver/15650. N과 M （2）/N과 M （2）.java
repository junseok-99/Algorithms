import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		dfs(1, 0, N, M, "");
		System.out.println(sb.toString());
	}

	public static void dfs(int idx, int depth, int N, int M, String s) {
		if (depth == M) {
			sb.append(s + "\n");
			return;
		}
		
		for (int i = idx; i <= N; i++) {
			dfs(i + 1, depth + 1, N, M, s + i + " ");
		}
	}
}