import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> q = new ArrayDeque<>(); 
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		while (q.size() > 1) {
			q.poll();
			q.add(q.poll());
		}
		System.out.println(q.peek());
	}
}