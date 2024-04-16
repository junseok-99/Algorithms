import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        int maxLen = -1;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxLen = Math.max(maxLen, arr[i]);
        }
        int l = 1, r = maxLen + 1;

        while (l < r) {
            int mid = (l + r) / 2;

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += (arr[i] / mid);
            }

            if (cnt < M) {
                r = mid;
            } else if (cnt >= M) {
                answer = mid;
                l = mid + 1;
            }
        }
        System.out.println(answer);
    }
}