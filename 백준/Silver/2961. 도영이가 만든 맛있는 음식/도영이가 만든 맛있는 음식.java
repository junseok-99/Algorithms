import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] bitters;
    static int[] sweets;
    static int N;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        bitters = new int[N];
        sweets = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            bitters[i] = Integer.parseInt(st.nextToken());
            sweets[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int bitterIdx, int bitter, int sweet, int depth) {
        if (depth > 0) {
            int sum = Math.abs(bitter - sweet);
            answer = Math.min(answer, sum);
        }

        for (int i = bitterIdx; i < N; i++) {
            dfs(i + 1,  bitter * bitters[i], sweet + sweets[i], depth + 1);
        }
    }
}