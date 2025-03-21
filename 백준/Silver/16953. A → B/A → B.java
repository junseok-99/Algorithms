import java.io.*;
import java.util.*;

class Main {
	
	static long A;
	static long B;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		answer = Integer.MAX_VALUE;
		
		dfs(A, 1);
		if (answer == Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);
	}
	
	public static void dfs(long num, int depth) {
		if (num > B) return;
		if (num == B) {
			answer = Math.min(answer, depth);
			return;
		}
		
		for (int i = 0; i < 2; i++) {
			if (i == 0) dfs(num * 2, depth + 1);
			else if (i == 1) dfs(num * 10 + 1, depth + 1);
		}
	}
}