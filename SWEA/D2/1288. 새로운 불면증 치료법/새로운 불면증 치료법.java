import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            long N = Long.parseLong(br.readLine());
            boolean[] flags = new boolean[10];
            int answer = 1;

            while (true) {
                long tmp = N * answer;

                boolean flag = true;
                for (int i = 0; i < 10; i++) {
                    if (!flags[i]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    break;
                }

                while (tmp > 0) {
                    flags[(int)(tmp % 10)] = true;
                    tmp /= 10;
                }
                answer++;
            }
            sb.append("#").append(tc).append(' ').append((answer - 1) * N).append("\n");
        }
        System.out.println(sb);
    }
}