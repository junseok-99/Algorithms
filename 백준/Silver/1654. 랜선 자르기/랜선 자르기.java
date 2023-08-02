import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] cables = new int[K];
        long left = 0;
        long right = 0;

        for(int i=0;i<K;i++) {
            cables[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, (long)cables[i]);
        }

        right++;

        while (left < right) {
            long mid = (left + right) / 2L;
            int ret = checkCable(cables, N, mid);

            if (ret < N) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left - 1);
    }

    public static int checkCable(int[] cables, int N, long div) {
        int sum = 0;

        for(int cable: cables) {
            sum += (int)((long)cable / div);
            if (sum > N) {
                break;
            }
        }
        return sum;
    }
}
