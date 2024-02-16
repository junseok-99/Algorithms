import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<List<Integer>> nodes = new ArrayList<>();
	static int N;
	static int M;
	static int V;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <= N; i++) {
			nodes.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodes.get(a).add(b);
			nodes.get(b).add(a);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(nodes.get(i));
		}
		
		visited = new boolean[N + 1];
		dfs(V);
		System.out.println(sb);
		
		visited = new boolean[N + 1];
		sb = new StringBuilder();
		bfs(V);
		System.out.println(sb);
	}

	public static void dfs(int node) {
		
		visited[node] = true;
		sb.append(node + " ");
		
		for (int child : nodes.get(node)) {
			if (!visited[child]) {
				dfs(child);
			}
		}
	}
	
	public static void bfs(int node) {
		Deque<Integer> q = new ArrayDeque<>();
		q.add(node);
		visited[node] = true;
		
		while (!q.isEmpty()) {
			int curNode = q.poll();
			sb.append(curNode + " ");
			
			for (int child : nodes.get(curNode)) {
				if (!visited[child]) {
					visited[child] = true;
					q.add(child);
				}
			}
		}
	}
}