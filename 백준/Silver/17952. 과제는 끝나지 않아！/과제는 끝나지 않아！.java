import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Work> deque = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int answer = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int workBit = Integer.parseInt(st.nextToken());
			
			if (workBit == 1) {
				int point = Integer.parseInt(st.nextToken());
				int minute = Integer.parseInt(st.nextToken());
				deque.addLast(new Work(point, minute));
			}
			
			if (deque.isEmpty()) continue;
			if (deque.peekLast().isFinish()) {
				answer += deque.pollLast().point;
			}
		}
		System.out.println(answer);
	}

}

class Work {
	int point;
	int minute;
	
	Work(int point, int minute) {
		this.point = point;
		this.minute = minute;
	}
	
	public boolean isFinish() {
		minute--;
		if (minute == 0) return true;
		return false;
	}
}