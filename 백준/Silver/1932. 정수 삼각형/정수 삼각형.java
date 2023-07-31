import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        int[][] dp = new int[n][n];
        int max = 0;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<i+1;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = map[0][0];

        for(int i=0;i<n-1;i++){
            for(int j=0;j<i+1;j++){
                dp[i+1][j]   = Math.max(dp[i+1][j], dp[i][j] + map[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + map[i+1][j+1]);
            }
        }

        for(int i=0;i<n;i++)
            if(dp[n-1][i] > max)
                max = dp[n-1][i];

        bw.write(max+"");
        bw.flush();
        bw.close();
    }
}
