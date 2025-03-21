import java.io.*;
import java.util.*;

class Main {
	
	static int N;
	static int K;
	static int[] d = {-1, 1, 2};
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		
		bfs();
		
		System.out.println(answer);
	}
	
	public static void bfs() {
		Deque<Subin> q = new ArrayDeque<>();
		boolean[] visited = new boolean[100001];
		q.add(new Subin(N, 0));
		visited[N] = true;
		
		while (!q.isEmpty()) {
			Subin subin = q.poll();
			visited[subin.pos] = true;
			if (subin.pos == K) {
				answer = Math.min(answer, subin.dist);
				return;
			}
			
			for (int i = 0; i < 3; i++) {
				int next = subin.pos;
				if (i == 2) next *= d[i];
				else next += d[i];
				
				if (next < 0 || next > 100000 || visited[next]) continue;
				
				if (i == 2) q.addFirst(new Subin(next, subin.dist));
				else q.add(new Subin(next, subin.dist + 1));
			}
		}
	}
}

class Subin {
	int pos;
	int dist;
	
	public Subin(int pos, int dist) {
		this.pos = pos;
		this.dist = dist;
	}
}