import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N][K + 1];
        int[][] bags = new int[N][2]; //0: weight, 1: value

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i][0] = Integer.parseInt(st.nextToken());
            bags[i][1] = Integer.parseInt(st.nextToken());
            if (i == 0) {
                for (int j = bags[i][0]; j <= K; j++) dp[i][j] = bags[i][1];
            }
        }

        for (int i = 1; i < N; i++) {
            int w = bags[i][0];
            int v = bags[i][1];
            for (int j = 1; j <= K; j++) {
                if (j - w < 0) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
            }
        }
        System.out.println(dp[N - 1][K]);
    }
}