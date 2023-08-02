import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] coords = new int[N];
        int maxDis = 0;

        for(int i=0;i<N;i++) {
            coords[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coords);
        
        int left = 1;
        int right = coords[N-1] - coords[0] + 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (checkWifi(coords, N, mid) < C) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left - 1);
    }

    public static int checkWifi(int[] coords, int N, int dis) {

        int sum = 1;
        int last = coords[0];

        for(int i=1;i<N;i++) {
            if (coords[i] - last >= dis) {
                last = coords[i];
                sum++;
            }
        }
        return sum;
    }
}
