import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int K;
	static int[] cables;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] cables = new int[K];
		
		long minLength = 0;
		long maxLength = -1;
		for (int i = 0; i < K; i++) {
			cables[i] = Integer.parseInt(br.readLine());
			maxLength = Math.max(maxLength, cables[i]);
		}
		maxLength++;
		
		while (minLength < maxLength) {
			long midLength = (maxLength + minLength) / 2L;
			
			int tmpN = 0;
			for (int cable : cables) {
				tmpN += (cable / midLength);
				if (tmpN > N) {
					break;
				}
			}
			
			if (tmpN >= N) {
				minLength = midLength + 1;
			} else if (tmpN < N) {
				maxLength = midLength;
			}
		}
		System.out.println(minLength - 1);
	}

}