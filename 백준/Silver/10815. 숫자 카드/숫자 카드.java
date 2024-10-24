import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(bs(arr, N, num)).append(" ");
        }
        System.out.println(sb);
    }

    public static int bs(int[] arr, int N, int ret) {
        int l = 0;
        int r = N - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] == ret) {
                return 1;
            } else if (arr[mid] > ret) {
                r = mid - 1;
            } else if (arr[mid] < ret) {
                l = mid + 1;
            }
        }
        return 0;
    }
}