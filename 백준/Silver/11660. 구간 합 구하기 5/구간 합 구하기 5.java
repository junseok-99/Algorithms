import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
                if (j > 0) {
                    dp[i][j] += dp[i][j-1];
                }
            }
            for(int j=0;j<N;j++) {
                if (i > 0) {
                    dp[i][j] += dp[i-1][j];
                }
            }
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int sum = 0;

            if (y1 -1 < 0 && x1 - 1 < 0) {
                sum = dp[y2][x2];
            } else if (y1 - 1 < 0) {
                sum = dp[y2][x2] - dp[y2][x1-1];
            } else if (x1 - 1 < 0) {
                sum = dp[y2][x2] - dp[y1-1][x2];
            } else {
                sum = dp[y2][x2] - dp[y1-1][x2] - dp[y2][x1-1] + dp[y1-1][x1-1];
            }
            bw.write(sum + "\n");
        }
        bw.flush();
        bw.close();

    }

}

