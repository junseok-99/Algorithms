import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[][] ret;
    static P startP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        ret = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    startP = new P(i, j, 0);
                }
            }
        }

        bfs();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && ret[i][j] == 0) {
                    sb.append("-1");
                } else {
                    sb.append(ret[i][j]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs() {
        boolean[][] visited = new boolean[n][m];
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Deque<P> q = new ArrayDeque<>();
        visited[startP.y][startP.x] = true;
        q.add(startP);

        while (!q.isEmpty()) {
            P p = q.poll();

            ret[p.y][p.x] = p.d;

            for (int i = 0; i < 4; i++) {
                int tx = p.x + d[i][0];
                int ty = p.y + d[i][1];

                if (invalidRange(ty, tx)) continue;
                if (visited[ty][tx] || map[ty][tx] == 0) continue;

                q.add(new P(ty, tx, p.d + 1));
                visited[ty][tx] = true;
            }
        }
    }

    public static boolean invalidRange(int y, int x) {
        return y < 0 || y >= n || x < 0 || x >= m;
    }
}

class P {
    int x;
    int y;
    int d;

    public P(int y, int x, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}