import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        int[] arr = new int[N+1];
        int[] arr2 = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = arr[i-1] + n;

        }
        for (int i=K;i<=N;i++) {
            arr2[i] = arr[i] - arr[i - K];
            max = Math.max(max, arr2[i]);
        }
        System.out.println(max);
    }
}