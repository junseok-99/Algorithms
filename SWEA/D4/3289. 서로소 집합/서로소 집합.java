import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n;
	static int m;
	static int[] nodes;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			nodes = new int[n + 1];
			sb.append("#").append(tc).append(' ');
			
			for (int i = 1; i <= n; i++) {
				nodes[i] = i;
			}
			
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int o = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if (o == 0) {
					union(a, b);
				} else if (o == 1) {
					sb.append(sameSet(a, b));
				}
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);
		
		if (aParent < bParent) {
			nodes[bParent] = aParent;
		} else {
			nodes[aParent] = bParent;
		}
	}
	
	public static int find(int node) {
		if (nodes[node] != node)
			nodes[node] = find(nodes[node]);
		return nodes[node];
	}
	
	public static int sameSet(int a, int b) {
		if (find(a) == find(b))
			return 1;
		return 0;
	}
}