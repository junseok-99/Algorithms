import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] += (num + arr[i - 1]);
		}
		
		for (int idx = 0; idx < M; idx++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			sb.append((arr[j] - arr[i - 1]) + "\n");
		}
		
		System.out.println(sb.toString());
	}
}