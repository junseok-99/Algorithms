import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			Deque<Integer> q = new ArrayDeque<>();
			
			//초기 암호 생성
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			//암호 생성중
			int cnt = 1;
			while (true) {
				
				int num = q.poll() - cnt++;
				if (num <= 0) {
					q.add(0);
					break;
				}
				q.add(num);
				
				if (cnt == 6) {
					cnt = 1;
				}
			}
			
			//최종 암호 출력
			sb.append("#").append(T).append(' ');
			while (!q.isEmpty()) {
				sb.append(q.poll()).append(' ');
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}