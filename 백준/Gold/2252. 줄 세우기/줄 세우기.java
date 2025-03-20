import java.io.*;
import java.util.*;

class Main {
	
	static int[] arr;
	static int N;
	static int M;
	static List<List<Integer>> li;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		li = new ArrayList<>();
		sb = new StringBuilder();
		
		for (int i = 0; i <= N; i++) {
			li.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[b]++;
			li.get(a).add(b);
		}
		
		topolSort();
		System.out.println(sb);
	}
	
	public static void topolSort() {
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (arr[i] == 0) q.add(i);
		}
		
		while (!q.isEmpty()) {
			int n = q.poll();
			sb.append(n).append(' ');
			
			for (int next : li.get(n)) {
				arr[next]--;
				if (arr[next] == 0) q.add(next);
			}
		}
	}
}