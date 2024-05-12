import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited = new boolean[29][29];
    static double[] ewnsArr = new double[4];
    static int N;
    static double answer = 0.0;
    static int[][] d = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 4; i++) {
            ewnsArr[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }

        visited[14][14] = true;
        backTrack(14, 14, 1.0, 0);
        System.out.println(answer);
    }

    public static void backTrack(int r, int c, double sum, int depth) {
        //System.out.println(depth);
        if (depth == N) {
            answer += sum;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int tr = r + d[i][0];
            int tc = c + d[i][1];
            if (visited[tr][tc]) continue;
            visited[tr][tc] = true;
            backTrack(tr, tc, sum * ewnsArr[i], depth + 1);
            visited[tr][tc] = false;
        }
    }
}