import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int K;
    static char[][] map;
    static int[][] visited;
    static int sr, sc, er, ec;
    static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] days = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int period = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            days[i][0] = period;
            days[i][1] = pay;
        }

        int[] dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            int period = i + days[i + 1][0];
            if (period <= N) dp[period] = Math.max(dp[i] + days[i + 1][1], dp[period]);
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        System.out.println(dp[N]);
    }
}