import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1+1][l2+1];

        for(int i=0;i<=l1;i++) {
            dp[i][0] = 0;
        }

        for(int i=0;i<=l2;i++) {
            dp[0][i] = 0;
        }

        for(int i=1;i<=l1;i++) {
            for(int j=1;j<=l2;j++) {
                char c1 = s1.charAt(i-1);
                char c2 = s2.charAt(j-1);
                if (c1 == c2) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[l1][l2]);
    }

}

