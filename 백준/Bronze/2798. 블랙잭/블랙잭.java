import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int N;
	static int M;
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		combi(0, 0, 0);
		
		System.out.println(answer);
	}

	public static void combi(int idx, int depth, int sum) {
		if (depth == 3) {
			if (sum <= M) {
				answer = Math.max(answer, sum);
			}
			return;
		}
		
		for (int i = idx; i < N; i++) {
			combi(i + 1, depth + 1, sum + arr[i]);
		}
	}
}