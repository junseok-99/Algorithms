import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken());
			arr[i] = n == 1 ? true : false;
		}

		int personN = Integer.parseInt(br.readLine());
		for (int i = 0; i < personN; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if (s == 1) {
				manSwitch(arr, num);
			} else if (s == 2) {
				girlSwitch(arr, num);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append((arr[i] ? 1 : 0) + " ");
			if (i % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	public static void manSwitch(boolean[] arr, int num) {
		for (int i = 1; validRange(num * i); i++) {
			int n = num * i;
			arr[n] = !arr[n];
		}
	}
	
	public static void girlSwitch(boolean[] arr, int num) {
		arr[num] = !arr[num];
		for (int i = 1; validRange(num - i) && validRange(num + i); i++) {
			int l = num - i;
			int r = num + i;
			if (arr[l] == arr[r]) {
				arr[l] = !arr[l];
				arr[r] = !arr[r];
			} else {
				return;
			}
		}
	}
	
	public static boolean validRange(int num) {
		return num > 0 && num <= N;
	}
}