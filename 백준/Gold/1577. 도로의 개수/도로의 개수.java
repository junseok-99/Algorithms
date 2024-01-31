import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[][] dp;
    static int N;
    static int M;
    static int[][] delta = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new long[M + 1][N + 1];
        dp[0][0] = 1;
        int K = Integer.parseInt(br.readLine());
        boolean[][][] nonRoad = new boolean[K][M + 1][N + 1];

        //공사 표시
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            nonRoad[i][b][a] = true;
            nonRoad[i][d][c] = true;
        }

        //이동
        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == M && j == N) {
                    break;
                }
                for (int k = 0; k < 2; k++) {
                    int ty = i + delta[k][0];
                    int tx = j + delta[k][1];
                    if (tx < 0 || tx > N || ty < 0 || ty > M) {
                        continue;
                    }

                    //공사중인 도로일 경우
                    boolean flag = true;
                    for (int r = 0; r < K; r++) {
                        if (nonRoad[r][i][j] && nonRoad[r][ty][tx]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag)
                        dp[ty][tx] += dp[i][j];
                }
            }
        }

        System.out.println(dp[M][N] == -1 ? 0 : dp[M][N]);
    }
}