import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            visited = new boolean[h][w];
            answer = 0;

            if (w + h == 0) {
                break;
            }

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j, w, h);
                        ++answer;
                    }
                }
            }
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void dfs(int y, int x, int w, int h) {
        visited[y][x] = true;

        for (int i = 0; i < 8; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (tx < 0 || tx >= w || ty < 0 || ty >= h) {
                continue;
            }

            if (map[ty][tx] == 1 && !visited[ty][tx]) {
                dfs(ty, tx, w, h);
            }
        }
    }
}