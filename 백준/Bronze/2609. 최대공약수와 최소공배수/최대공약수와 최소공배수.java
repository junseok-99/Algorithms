import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		
		System.out.println(gcd(n1, n2));
		System.out.println(lcm(n1, n2));
	}
	
	public static int gcd(int n1, int n2) {
		if (n1 % n2 == 0) return n2;
		return gcd(n2, n1 % n2);
	}
	
	public static int lcm(int n1, int n2) {
		return n1 * n2 / gcd(n1, n2);
	}
}