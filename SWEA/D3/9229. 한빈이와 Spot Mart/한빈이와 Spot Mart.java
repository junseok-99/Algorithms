import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int answer = -1;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] snacks = new int[N];
            
            //과자 담기
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                snacks[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(snacks);

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N && snacks[i] + snacks[j] <= M; j++) {
                    answer = Math.max(answer, snacks[i] + snacks[j]);
                }
            }
            sb.append("#" + tc + " " + answer + "\n");
        }
        System.out.println(sb);
    }
}