import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] cups = new boolean[N + 1];
		cups[X] = true;
			
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
				
			if (!cups[l] && !cups[r]) continue; //두 컵에 간식이 들어있지 않을 때
			else if (cups[l] || cups[r]) { //두 컵중 한 컵에 간식이 들어있을 때
				if (cups[l]) {
					cups[l] = false;
					cups[r] = true;
					X = r;
				} else if (cups[r]) {
					cups[r] = false;
					cups[l] = true;
					X = l;
				}
			}
		}
		
		
		System.out.println(X);
		
	}

}
