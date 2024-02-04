import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] map = new int[W];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            int n = Integer.parseInt(st.nextToken());
            map[i] = n;
        }

        for (int i = 1; i < W - 1; i++) {
            int maxL = 0;
            int maxR = 0;

            for (int j = 0; j < i; j++) {
                maxL = Math.max(maxL, map[j]);
            }

            for (int j = i + 1; j < W; j++) {
                maxR = Math.max(maxR, map[j]);
            }

            int minHeight = Math.min(maxL, maxR);
            if (minHeight > map[i]) {
                answer += (minHeight - map[i]);
            }
        }
        System.out.println(answer);
    }
}