import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[][] ans = new int[N][N];
        int[] dp = new int[N];
        int max = 1;
        int maxIdx = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            int idx = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        idx = 0;
                        for (int k = 0; k < dp[j]; k++) {
                            ans[i][k] = ans[j][k];
                            ++idx;
                        }
                    }
                }
            }
            ans[i][idx] = arr[i];

            if (max < dp[i]) {
                max = dp[i];
                maxIdx = i;
            }
        }

        System.out.println(max);
        for (int i = 0; i < max; i++) {
            System.out.print(ans[maxIdx][i] + " ");
        }
    }
}