import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] dp = new long[N+1];
        dp[1] = 1L;

        if (N > 1) {
            dp[2] = 2L;
        }

        for(int i=3;i<=N;i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 15746L;
        }

        System.out.println(dp[N]);

        //1
        //00, 11
        //100 001 111
        //1100 0011 1111 0000 1001
        //11100 11001 10011 00111 10011 11111 10000 00001
    }
}
