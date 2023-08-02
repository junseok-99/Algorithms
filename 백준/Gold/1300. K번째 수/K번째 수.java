import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int left = 1;
        int right = k;

        while (left < right) {
            int mid = (left + right) / 2;
            int ret = countUnderBound(N, mid);
            if (ret < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
    }

    public static int countUnderBound(int N, int num) {
        int cnt = 0;
        for(int i=1;i<=N;i++) {
            if (num / i == 0) {
                break;
            }
            cnt += Math.min(N, (num / i));
        }
        return cnt;
    }

}
