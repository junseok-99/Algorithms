import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static boolean[] visited;
	static List<List<Integer>> nodes;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int T = 1; T <= 10; T++) {
			nodes = new ArrayList<>();
			visited = new boolean[101];
			
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			//리스트 초기화
			for (int i = 0; i <= 100; i++) {
				nodes.add(new ArrayList<>());
			}
	
			//리스트 연결하기
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < len / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				nodes.get(from).add(to);
			}
			
			int answer = bfs(start);
			sb.append("#").append(T).append(' ').append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int bfs(int start) {
		Deque<Integer> q = new ArrayDeque<>();
		q.add(start);
		visited[start] = true;
		int minNum = Integer.MIN_VALUE;
		
		while (!q.isEmpty()) {
			int size = q.size();
			minNum = Integer.MIN_VALUE;
			while (size-- > 0) {
				int node = q.poll();
				minNum = Math.max(minNum, node);
				
				for (int to : nodes.get(node)) {
					if (!visited[to]) {
						visited[to] = true;
						q.add(to);
					}
				}
			}
		}
		return minNum;
	}
}