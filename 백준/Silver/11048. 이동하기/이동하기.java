import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] dp = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = map[0][0];

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if (i - 1 > -1) {
                    dp[i][j] = Math.max(dp[i][j], map[i][j] + dp[i-1][j]);
                }
                if (j - 1 > -1) {
                    dp[i][j] = Math.max(dp[i][j], map[i][j] + dp[i][j-1]);
                }
                if (i - 1 > -1 && j - 1 > -1) {
                    dp[i][j] = Math.max(dp[i][j], map[i][j] + dp[i-1][j-1]);
                }
            }
        }
        
        bw.write(dp[N-1][M-1] + "");
        bw.flush();
        bw.close();

    }

}

