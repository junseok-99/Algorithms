import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < W - 1; i++) {
            int maxL = Integer.MIN_VALUE;
            int maxR = Integer.MIN_VALUE;

            for (int j = 0; j < i; j++) {
                maxL = Math.max(maxL, arr[j]);
            }

            for (int j = i + 1; j < W; j++) {
                maxR = Math.max(maxR, arr[j]);
            }

            int minH = Math.min(maxL, maxR);
            if (minH - arr[i] > 0) answer += minH - arr[i];
        }
        System.out.println(answer);
    }
}