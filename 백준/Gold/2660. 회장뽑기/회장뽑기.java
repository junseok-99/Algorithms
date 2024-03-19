import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static List<List<Integer>> nodes = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= N; i++) {
			nodes.add(new ArrayList<>());
		}
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1) break;
			
			nodes.get(b).add(a);
			nodes.get(a).add(b);
		}
		
		List<Integer> answer = new LinkedList<>();
		int minScore = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int score = bfs(i);
			if (minScore > score) {
				minScore = score;
				answer.clear();
			}
			if (minScore == score)
				answer.add(i);
		}
		Collections.sort(answer);
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(minScore).append(' ').append(answer.size()).append("\n");
		for (int n: answer) {
			sb.append(n).append(' ');
		}
		System.out.println(sb);
	}
	
	public static int bfs(int start) {
		Deque<Integer> q = new ArrayDeque<>();
		q.add(start);
		boolean[] visited = new boolean[N + 1];
		int score = -1;
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int size = q.size();
			score++;
			while (size-- > 0) {
				int curNode = q.poll();
				
				for (int neighNum: nodes.get(curNode)) {
					if (visited[neighNum]) continue;
					visited[neighNum] = true;
					q.add(neighNum);
				}
			}
		}
		return score;
	}
}