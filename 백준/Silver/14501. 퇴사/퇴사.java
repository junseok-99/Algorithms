import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] info = new int[N+1][2];
        int[] dp = new int[N+2];

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=N;i>0;i--) {
            if (i + info[i][0] > N+1) {
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.max(dp[i+info[i][0]] + info[i][1], dp[i+1]);
            }
        }
        System.out.println(dp[1]);

    }
}