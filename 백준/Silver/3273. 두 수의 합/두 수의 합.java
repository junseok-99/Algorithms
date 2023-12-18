import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0;i < N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());
        int l = 0, r = N - 1;
        int answer = 0;
        Arrays.sort(arr);

        while (l < r) {
            int sum = arr[l] + arr[r];

            if (sum == X) {
                ++l;
                --r;
                ++answer;
            } else if (sum < X) {
                ++l;
            } else if (sum > X) {
                --r;
            }
        }
        System.out.println(answer);
    }
}