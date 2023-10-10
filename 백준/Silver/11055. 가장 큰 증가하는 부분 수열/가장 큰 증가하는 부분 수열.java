import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int[] arr = new int[A];
        int[] dp = new int[A];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<A;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
        }

        for(int i=0;i<A;i++) {
            for(int j=0;j<i;j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
                }
            }
        }

        int max = -1;
        for(int i=0;i<A;i++) {
            max = Math.max(max, dp[i]);
        }

        bw.write(max + "");
        bw.flush();
        bw.close();

    }

}

