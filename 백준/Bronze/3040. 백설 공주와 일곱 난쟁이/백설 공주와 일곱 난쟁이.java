import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] dwarfs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dwarfs = new int[9];
		for (int i = 0; i < 9; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(dwarfs);
		
		dfs(0, 0, 0, "");
	}

	//중복 X 조합
	public static void dfs(int idx, int depth, int sum, String s) {
		if (depth == 7) {
			if (sum == 100) {
				for (String d : s.split(" ")) {
					System.out.println(d);
				}
				System.exit(0);
			}
			return;
		}
		
		for (int i = idx; i < 9; i++) {
			dfs(i + 1, depth + 1, sum + dwarfs[i], s + dwarfs[i] + " ");
		}
	}
}