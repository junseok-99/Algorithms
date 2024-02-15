import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] sosu = {2, 3, 5, 7};
        for (int n: sosu) {
        	dfs(1, n);
        }
	}
	
	public static void dfs(int depth, int num) {
		if (depth == N) {
			System.out.println(num);
			return;
		}
		for (int i = 1; i <= 9; i++) {
			int changedNum = 10 * num + i;
			if (!isPrime(changedNum)) continue;
			dfs(depth + 1, changedNum);
		}
	}
	
	public static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}