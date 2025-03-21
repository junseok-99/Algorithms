import java.io.*;
import java.util.*;

class Main {
	
	static int N;
	static int K;
	static int[] d = {-1, 1, 2};
	static int[] times;
	static int[] parents;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		times = new int[100001];
		parents = new int[100001];
		sb = new StringBuilder();
		
		bfs();
		
		System.out.println(times[K] - 1);
		
		Deque<Integer> stack = new ArrayDeque<>();
		dfs(K, stack);
		
		while (!stack.isEmpty()) sb.append(stack.pop()).append(' ');
		System.out.println(sb);
	}
	
	public static void bfs() {
		Deque<Integer> q = new ArrayDeque<>();
		q.add(N);
		times[N] = 1;
		
		while (!q.isEmpty()) {
			int subin = q.poll();
			if (subin == K) return;
			
			for (int i = 0; i < 3; i++) {
				int next = subin;
				if (i == 2) next *= d[i];
				else next += d[i];
				
				if (next < 0 || next > 100000 || times[next] != 0) continue;
				
				if (i == 2) q.addFirst(next);
				else q.add(next);
				times[next] = times[subin] + 1 ;
				parents[next] = subin;
			}
		}
	}
	
	public static void dfs(int num, Deque<Integer> stack) {
		stack.push(num);;
		if (num == N) return;
		dfs(parents[num], stack);
	}
}