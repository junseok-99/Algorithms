import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];

        Arrays.fill(dp[1], 1);

        int sum = 10;
        for(int i=2;i<=N;i++) {
            int tmp = 0;
            for(int j=0;j<10;j++) {
                dp[i][j] = sum % 10007;
                sum -= dp[i-1][j];
                tmp += dp[i][j];
            }
            sum = tmp;
        }

        bw.write(sum % 10007 + "");

        bw.flush();
        bw.close();

    }

}

