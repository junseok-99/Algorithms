import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[n];


        st = new StringTokenizer(br.readLine());
        dp[0] = Integer.parseInt(st.nextToken());
        int max = dp[0];

        for(int i=1;i<n;i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(dp[i-1] + tmp < 0)
                dp[i] = 0;
            else
                dp[i] = dp[i-1] + tmp;

            max = Math.max(Math.max(max, dp[i-1] + tmp), tmp);
        }

        System.out.println(max);

    }
}
