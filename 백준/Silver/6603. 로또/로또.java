import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] lotto;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			
			if (k == 0) {
				break;
			}
			
			lotto = new int[k];
			visited = new boolean[k];
			for (int i = 0; i < k; i++) {
				lotto[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0, k, "");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int idx, int depth, int k, String s) {
		if (depth == 6) {
			sb.append(s + "\n");
		}
		
		for (int i = idx; i < k; i++) {
			dfs(i + 1, depth + 1, k, s + lotto[i] + " ");
		}
	}
}