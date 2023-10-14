import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;

        for(int i=4;i<=N;i++) {
            dp[i] = Math.min(dp[i-1], dp[i-3]) + 1;
        }

        if (dp[N] % 2 == 0) {
            bw.write("CY");
        } else {
            bw.write("SK");
        }

        bw.flush();
        bw.close();

    }

}

