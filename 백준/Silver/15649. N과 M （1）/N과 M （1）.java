import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		
		dfs(0, "");
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int depth, String s) {
		if (depth == M) {
			sb.append(s + "\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			dfs(depth + 1, s + i + " ");
			visited[i] = false;
		}
	}
}
