import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            int[][] dp = new int[2][n];
            int answer = -1;

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    if (i == 0) {
                        dp[j][i] = arr[j][i];
                    } else {
                        if (j == 0) {
                            dp[j][i] = Math.max(dp[j][i], dp[1][i - 1] + arr[j][i]);
                        } else {
                            dp[j][i] = Math.max(dp[j][i], dp[0][i - 1] + arr[j][i]);
                        }
                    }

                    if (i >= 2) {
                        dp[j][i] = Math.max(dp[j][i], Math.max(dp[0][i - 2] + arr[j][i], dp[1][i - 2] + arr[j][i]));
                    }

                    answer = Math.max(answer, dp[j][i]);
                }
            }
            bw.write(answer + "\n");
        }
        bw.close();
    }
}