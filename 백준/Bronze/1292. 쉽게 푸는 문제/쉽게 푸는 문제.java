import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int number = 1;
        int repeat = 1;
        int[] dp = new int[1001];

        while (cnt++ < r) {
            dp[cnt] = dp[cnt - 1] + number;
            repeat--;
            if (repeat == 0) {
                repeat = ++number;
            }
        }
        System.out.println(dp[r] - dp[l - 1]);
    }
}