import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
			int an1 = Math.abs(n1);
			int an2 = Math.abs(n2);
			if (an1 == an2) {
				return n1 - n2;
			}
			return an1 - an2;
		});
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (pq.isEmpty()) 
					sb.append("0\n");
				else 
					sb.append(pq.poll() + "\n");
			} else {
				pq.add(num);
			}
		}
		
		System.out.println(sb);
	}

}