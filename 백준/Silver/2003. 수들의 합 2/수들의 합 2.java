import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int l = 0;
        int r = 0;
        int sum = 0;
        int answer = 0;
        st = new StringTokenizer(br.readLine());

        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        while (true) {
            if (sum >= M) {
                sum -= arr[l++];
            } else if (r == N) {
                break;
            } else if (sum < M) {
                sum += arr[r++];
            }
            if (sum == M) {
                ++answer;
            }
        }
        System.out.println(answer);
    }
}