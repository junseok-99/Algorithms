import java.io.*;
import java.util.*;

class Main {
	
	static int[] parents;
	static int V;
	static int E;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int cnt = 1;
		int answer = 0;
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parents = new int[V + 1];
		
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.add(new Edge(s, d, w));
		}
		
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if (union(edge)) {
				++cnt;
				answer += edge.w;
			}
			if (cnt == V) break;
		}
		System.out.println(answer);
	}
	
	public static boolean union(Edge e) {
		int n1 = find(e.s);
		int n2 = find(e.d);
		
		if (n1 == n2) return false;
		if (n1 < n2) {
			parents[n2] = n1;
		} else if (n2 < n1) {
			parents[n1] = n2;
		}
		return true;
	}
	
	public static int find(int n) {
		if (parents[n] == n) return n;
		return parents[n] = find(parents[n]);
	}
}

class Edge implements Comparable<Edge> {
	int s;
	int d;
	int w;
	
	public Edge(int s, int d, int w) {
		this.s = s;
		this.d = d;
		this.w = w;
	}
	
	public int compareTo(Edge eo) {
		return Integer.compare(this.w, eo.w);
	}
}