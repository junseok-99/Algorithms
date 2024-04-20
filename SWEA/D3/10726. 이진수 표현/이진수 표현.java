import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if ((M & (1 << N) - 1) == (1 << N) - 1) {
                sb.append("#").append(tc).append(' ').append("ON").append("\n");
            } else {
                sb.append("#").append(tc).append(' ').append("OFF").append("\n");
            }
        }
        System.out.println(sb);
    }
}