import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] houses = new int[N];
            int l = 0, r = M - 1;
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                houses[i] = Integer.parseInt(st.nextToken());
                if (i < M) sum += houses[i];
            }

            while (true) {
                if (sum < K) ++answer;
                if (N == M) break;

                sum -= houses[l++ % N];
                sum += houses[++r % N];

                if (l % N == 0) break;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}