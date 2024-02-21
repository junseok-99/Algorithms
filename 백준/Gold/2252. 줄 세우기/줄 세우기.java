import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static List<List<Integer>> stu = new ArrayList<>();
	static boolean[] visited;
	static List<Integer> r = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		
		for (int i = 0; i <= n; i++) {
			stu.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			stu.get(a).add(b);
		}
		
		topol();
		
		StringBuilder sb = new StringBuilder();
		for (int i = n - 1; i >= 0; i--) {
			sb.append(r.get(i)).append(' ');
		}
		System.out.println(sb);
	}

	public static void topol() {
		
		for (int i = 1; i <= n; i++) {
			if (!visited[i])
				dfs(i);
		}
	}
	
	public static void dfs(int v) {
		visited[v] = true;
		for (int i : stu.get(v)) {
			if (!visited[i])
				dfs(i);
		}
		r.add(v);
	}
}