import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int m;
    private static int n;
    private static int answer = 0;
    private static int[][] map;
    private static int[][] dp;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        dp = new int[m][n];

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0,0));
    }

    public static int dfs(int y, int x) {
        if (y == m - 1 && x == n - 1) {
            return 1;
        }

        if (dp[y][x] != -1) {
            return dp[y][x];
        } else {
            dp[y][x] = 0;

            for(int i=0;i<4;i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];

                if (tx < 0 || tx == n || ty < 0 || ty == m) {
                    continue;
                }

                if (map[ty][tx] < map[y][x]) {
                    dp[y][x] += dfs(ty, tx);
                }
            }
        }

        return dp[y][x];
    }

}
