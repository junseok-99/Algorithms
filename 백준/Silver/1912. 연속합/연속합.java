import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        int answer = dp[0];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += dp[i];
            answer = Math.max(answer, sum);
            if (sum < 0) sum = 0;
        }
        System.out.println(answer);
    }
}