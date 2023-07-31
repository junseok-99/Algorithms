import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int combi(int[][] dp, int m, int n) {
        if (dp[m][n] > 0) {
            return dp[m][n];
        } else if (n == m || n == 0) {
            return 1;
        }
        return dp[m][n] = combi(dp, m-1, n-1) + combi(dp, m-1, n);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[31][31];

        for(int i=0;i<T;i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            System.out.println(combi(dp, m, n));
        }

    }
}