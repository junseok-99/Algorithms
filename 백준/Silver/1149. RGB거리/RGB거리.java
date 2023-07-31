import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r,g,b,min=Integer.MAX_VALUE;

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[][] dp = new int[N][3];

        dp[0][0] = Integer.parseInt(st.nextToken());
        dp[0][1] = Integer.parseInt(st.nextToken());
        dp[0][2] = Integer.parseInt(st.nextToken());

        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            for(int j=0;j<3;j++){
                if(j==0)
                    dp[i][j] = Math.min(dp[i-1][1]+r ,dp[i-1][2]+r );
                else if(j==1)
                    dp[i][j] = Math.min(dp[i-1][0]+g ,dp[i-1][2]+g );
                else if(j==2)
                    dp[i][j] = Math.min(dp[i-1][0]+b ,dp[i-1][1]+b );

                if(i==N-1 && dp[i][j] < min)
                    min = dp[i][j];
            }
        }
        
        bw.write(min+"");
        bw.flush();
        bw.close();

    }

}
