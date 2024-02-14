import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int cnt = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j <= 9; j++) {
                dfs(j, i, j + "");
            }
        }
        System.out.println(-1);
    }

    public static void dfs(int front, int depth, String num) {
        if (depth == 1) {
            if (cnt == N) {
                System.out.println(num);
                System.exit(0);
            }
            ++cnt;
            return;
        }

        for (int i = 0; i < front; i++) {
                dfs(i, depth - 1, num + i);
        }
    }
}