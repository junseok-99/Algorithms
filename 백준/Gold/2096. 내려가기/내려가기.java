import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        int[][] minDp = new int[N][3];
        int[][] maxDp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(minDp[i], Integer.MAX_VALUE);
        }

        minDp[0][0] = map[0][0];
        minDp[0][1] = map[0][1];
        minDp[0][2] = map[0][2];
        maxDp[0][0] = map[0][0];
        maxDp[0][1] = map[0][1];
        maxDp[0][2] = map[0][2];

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = -1; k <= 1; k++) {
                    if (j + k < 0 || j + k >= 3) continue;
                    minDp[i + 1][j + k] = Math.min(minDp[i + 1][j + k], minDp[i][j] + map[i + 1][j + k]);
                    maxDp[i + 1][j + k] = Math.max(maxDp[i + 1][j + k], maxDp[i][j] + map[i + 1][j + k]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, minDp[N - 1][i]);
            max = Math.max(max, maxDp[N - 1][i]);
        }
        System.out.println(max + " " + min);
    }
}