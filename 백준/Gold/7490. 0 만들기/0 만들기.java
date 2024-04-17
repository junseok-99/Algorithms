import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static List<String> li;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			li = new ArrayList<>();
			dfs(2, N, 1, 1 + "");
			
			Collections.sort(li);
			for (String s : li) {
				sb.append(s).append("\n");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int n, int end, int sum, String op) {
		if (n == end + 1) {
			if (calcZero(op.replace(" ", ""))) {
				li.add(op);
			}
			return;
		}
			
		dfs(n + 1, end, sum + n, op + "+" + n);
		dfs(n + 1, end, sum - n, op + "-" + n);
		dfs(n + 1, end, sum + n, op + " " + n);
	}
	
	public static boolean calcZero(String s) {
		String[] ops = s.split("[1-9]");
		String[] nums = s.split("[^1-9]");
		
		int sum = Integer.parseInt(nums[0]);
		
		int idx = 1;
		for (int i = 1; i < ops.length; i++) {
			int num = Integer.parseInt(nums[idx]);
			if (ops[i].equals("+")) {
				sum += num;
				idx++;
			} else if (ops[i].equals("-")) {
				sum -= num;
				idx++;
			}
		}

		if (sum == 0) return true;
		return false;
	}
}