import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int Q;
	static int[][] usados = new int[5][5];
	static List<List<Node>> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int usado = Integer.parseInt(st.nextToken());
			list.get(a).add(new Node(b, usado));
			list.get(b).add(new Node(a, usado));
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			sb.append(bfs(v, k)).append("\n");
		}

		System.out.println(sb);
	}
	
	public static int bfs(int start, int k) {
		Deque<Node> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		int answer = 0;
		visited[start] = true;
		q.add(new Node(start, Integer.MAX_VALUE));
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			
			for (Node neighbor : list.get(node.n)) {
				if (visited[neighbor.n]) continue;
				visited[neighbor.n] = true;
				int usado = Math.min(node.usado, neighbor.usado);
				
				if (usado >= k) {
					++answer;
				}
				q.add(new Node(neighbor.n, usado));
			}
		}
		return answer;
	}
}

class Node {
	int n;
	int usado;
	
	public Node(int n, int usado) {
		this.n = n;
		this.usado = usado;
	}
}