import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] minDp = new int[3];
        int[] maxDp = new int[3];

        for (int i = 0; i < N; i++) {
            int[] arr = new int[3];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            if (i == 0) {
                minDp[0] = maxDp[0] = arr[0];
                minDp[1] = maxDp[1] = arr[1];
                minDp[2] = maxDp[2] = arr[2];
            } else {
                int beforeMD_0 = minDp[0];
                int beforeMD_2 = minDp[2];
                minDp[0] = Math.min(minDp[0], minDp[1]) + arr[0];
                minDp[2] = Math.min(minDp[1], minDp[2]) + arr[2];
                minDp[1] = Math.min(beforeMD_0, Math.min(minDp[1], beforeMD_2)) + arr[1];

                int beforeMXD_0 = maxDp[0];
                int beforeMXD_2 = maxDp[2];
                maxDp[0] = Math.max(maxDp[0], maxDp[1]) + arr[0];
                maxDp[2] = Math.max(maxDp[1], maxDp[2]) + arr[2];
                maxDp[1] = Math.max(beforeMXD_0, Math.max(maxDp[1], beforeMXD_2)) + arr[1];
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, minDp[i]);
            max = Math.max(max, maxDp[i]);
        }
        System.out.println(max + " " + min);
    }
}