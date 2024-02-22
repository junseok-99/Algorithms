import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[] parents;
	static Edge[] edges;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			edges = new Edge[E];
			
			//간선 초기화
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(from, to, weight);
			}
			//간선 가중치 기준 오름차순
			Arrays.sort(edges);
			
			make(V);
			
			long weightSum = 0;
			int cnt = 0;
			for (Edge edge : edges) {
				if (!union(edge.from, edge.to)) continue;
				weightSum += edge.weight;
				if (++cnt == V - 1) break;
			}
			
			sb.append("#").append(tc).append(' ').append(weightSum).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void make(int V) {
		parents = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}

	public static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA == rootB) return false;
		parents[rootB] = rootA;
		return true;
	}
	
	public static int find(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
}

class Edge implements Comparable<Edge> {
	int from;
	int to;
	long weight;
	
	public Edge(int from, int to, long weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return Long.compare(this.weight, o.weight);
	}
}