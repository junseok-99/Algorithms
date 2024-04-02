import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int l = 0;
		int r = N - 1;
		int sum = 0;
		int minSum = Integer.MAX_VALUE;
		int[] answer = new int[2];
		while (l < r && minSum > 0) {
			sum = Math.abs(arr[l] + arr[r]);
			
			if (sum < minSum) {
				minSum = sum;
				answer = new int[] {arr[l], arr[r]};
			} 
			
			if (arr[l] + arr[r] < 0) {
				l++;
			} else {
				r--;
			}
		}
		System.out.println(answer[0] + " " + answer[1]);
	}
}