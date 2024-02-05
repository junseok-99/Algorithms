import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder("<");
		
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		int idx = 0;
		while (!q.isEmpty()) {
			int n = q.poll();
			if ((idx + 1) % K == 0) {
				if (q.isEmpty()) {
					sb.append(n).append(">");
					break;
				}
				sb.append(n).append(", ");
			} else {
				q.add(n);
			}
			idx++;
		}
		System.out.println(sb);
	}
	

}