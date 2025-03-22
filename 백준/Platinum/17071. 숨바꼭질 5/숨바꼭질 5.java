import java.io.*;
import java.util.*;

class Main {
	
	static int N;
	static int K;
	static int[] d = {-1, 1, 2};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		if (N == K) return 0;

		int time =0;
		Deque<Integer> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[2][500001];
		q.add(N);
		visited[time][N] = true;
		
		
		while (!q.isEmpty()) {
			int size = q.size();
			K += ++time;
			while (size-- > 0) {
				int pos = q.poll();
				if (K > 500_000) return -1;
				
				for (int i = 0; i < 3; i++) {
					int next = pos;
					if (i == 2) next *= d[i];
					else next += d[i];
					
					if (next < 0 || next > 500_000) continue;
					if (visited[time % 2][next]) continue;
					q.add(next);
					visited[time % 2][next] = true;
					
					if (visited[time % 2][K]) return time;
				}
			}
			
		}
		return -1;
	}
}