import java.io.*;
import java.util.*;

class Main {
	
	static int N;
	static int K;
	static int[] times;
	static int cnt;
	static int[] d = {-1, 1, 2};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		times = new int[100_101];
		bfs();
		System.out.println(times[K]);
		System.out.println(cnt);
	}
	
	public static void bfs() {
		Deque<Integer> q = new ArrayDeque<>();
		q.add(N);
		
		if (N == K) ++cnt;
		
		while (!q.isEmpty() && N != K) {
			int pos = q.poll();
				
			if (pos == K) {
				++cnt;
			}
			
			for (int i = 0; i < 3; i++) {
				int next = pos;
				if (i == 2) next *= d[i];
				else next += d[i];
				
				if (next < 0 || next > 100000 || (times[next] != 0 && times[pos] + 1 > times[next])) continue;
				times[next] = times[pos] + 1;
				q.add(next);
			}
			
		}
	}
}