import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int answer = -1;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] nums = new int[N + 1][M + 1];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                nums[i+1][0] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                nums[0][i+1] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    nums[i + 1][j + 1] = nums[i+1][0] * nums[0][j+1];
                }
            }

            if (N <= M) {
                for (int i = 1; i <= M - N + 1; i++) {
                    answer = Math.max(answer, sum(nums, 1, i, 0));
                }
            } else {
                for (int i = 1; i <= N - M + 1; i++) {
                    answer = Math.max(answer, sum(nums, i, 1, 0));
                }
            }
            bw.write("#" + tc + " " + answer + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int sum(int[][] nums, int y, int x, int sum) {
        try {
            return sum(nums, y + 1, x + 1, sum + nums[y][x]);
        } catch (ArrayIndexOutOfBoundsException e) {
            return sum;
        }
    }
}