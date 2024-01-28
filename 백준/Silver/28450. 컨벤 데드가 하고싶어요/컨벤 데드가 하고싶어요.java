import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][M + 1];
        long[][] dp = new long[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int H = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (j == 1) {
                    dp[i][j] += (dp[i - 1][j] + map[i][j]);
                } else if (i == 1) {
                    dp[i][j] += (dp[i][j - 1] + map[i][j]);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + map[i][j], dp[i][j - 1] + map[i][j]);
                }
            }
        }

        if (H >= dp[N][M]) {
            bw.write("YES\n");
            bw.write(dp[N][M] + "");
        } else {
            bw.write("NO\n");
        }
        bw.close();
    }
}