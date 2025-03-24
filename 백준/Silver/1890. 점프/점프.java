import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static long[][] dp;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == N - 1 && j == N - 1) break;
                for (int k = 0; k < 2; k++) {
                    int tr = i;
                    int tc = j;
                    if (k == 0) tr += map[i][j];
                    else tc += map[i][j];
                    if (invalidRange(tr, tc)) continue;

                    dp[tr][tc] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N - 1][N - 1]);
    }

    public static boolean invalidRange(int tr, int tc) {
        return tr < 0 || tr >= N || tc < 0 || tc >= N;
    }
}