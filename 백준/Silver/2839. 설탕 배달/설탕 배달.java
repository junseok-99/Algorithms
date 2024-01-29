import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int three = 0;
		
		while (true) {
			if (N % 5 == 0) {
				System.out.println(three + N / 5);
				break;
			} else if (N < 0) {
				System.out.println(-1);
				break;
			}
			N -= 3;
			three++;
		}
	}
}

