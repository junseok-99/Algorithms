import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int M;
	static List<List<Integer>> diList;
	static List<List<Integer>> reverList;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			diList = new ArrayList<>();
			reverList = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			for (int i = 0; i <= N; i++) {
				diList.add(new ArrayList<>());
				reverList.add(new ArrayList<>());
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				diList.get(a).add(b);
				reverList.get(b).add(a);
			}
			
			int answer = 0;
			for (int i = 1; i <= N; i++) {
				visited = new boolean[N + 1];
				cnt = 0;
				dfs(i, i);
				visited = new boolean[N + 1];
				dfs2(i, i);
				
				if (cnt == N - 1) ++answer;
			}

			sb.append("#").append(tc).append(' ').append(answer).append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int start, int end) {
		
		visited[end] = true;
		for (int nei : diList.get(end)) {
			if (!visited[nei]) {
				++cnt;
				dfs(start, nei);
			}
		}
	}
	
	public static void dfs2(int start, int end) {
		
		visited[end] = true;
		
		for (int nei : reverList.get(end)) {
			if (!visited[nei]) {
				++cnt;
				dfs2(start, nei);
			}
		}
	}
}