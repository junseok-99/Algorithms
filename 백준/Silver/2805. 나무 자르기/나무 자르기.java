import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int maxHeight = -1;
        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, trees[i]);
        }

        int left = 1;
        int right = maxHeight;

        while (left < right) {
            int mid = (left + right) / 2;
            long sumCutTreeLen = 0L;
            for (int i = 0; i < N; i++) {
                long cutTreeLen = (long)trees[i] - (long)mid;
                if (cutTreeLen > 0) {
                    sumCutTreeLen += cutTreeLen;
                }
            }

            if (sumCutTreeLen >= (long)M) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(right - 1);
    }
}