import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[100];
        dp[0] = 1L;
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 2L;
        dp[4] = 2L;

        for(int i=5;i<100;i++) {
            dp[i] = dp[i-1] + dp[i-5];
        }

        for(int i=0;i<N;i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())-1]);
        }
    }
}
