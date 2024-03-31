import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int R;
    static int C;
    static boolean[][] map;
    static boolean[][] visited;
    static int cheese;
    static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1) {
                    ++cheese;
                    map[i][j] = true;
                }
            }
        }

        int time = 0;
        while (cheese > 0) {
            bfs(0, 0);
            ++time;
        }
        System.out.println(time);
    }

    public static void bfs(int y, int x) {
        Deque<P> q = new ArrayDeque<>();
        Deque<P> meltQ = new ArrayDeque<>();
        q.add(new P(y, x));
        visited = new boolean[R][C];
        visited[y][x] = true;

        while (!q.isEmpty()) {
            P p = q.poll();

            for (int i = 0; i < 4; i++) {
                int tx = p.x + d[i][0];
                int ty = p.y + d[i][1];

                if (invalidRange(tx, ty) || visited[ty][tx]) continue;

                visited[ty][tx] = true;
                if (map[ty][tx]) { //Cheese
                    meltQ.add(new P(ty, tx));
                } else { //not cheese
                    q.add(new P(ty, tx));
                }
            }
        }
        melt(meltQ);
    }

    public static void melt(Deque<P> q) {
        Deque<P> tmpQ = new ArrayDeque<>();

        while (!q.isEmpty()) {
            P p = q.poll();

            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int tx = p.x + d[i][0];
                int ty = p.y + d[i][1];
                if (invalidRange(tx, ty)) continue;
                if (!map[ty][tx] && visited[ty][tx]) ++cnt;
            }

            if (cnt >= 2) {
                tmpQ.add(p);
            }
        }

        while (!tmpQ.isEmpty()) {
            P p = tmpQ.poll();
            map[p.y][p.x] = false;
            --cheese;
        }
    }

    public static boolean invalidRange(int x, int y) {
        return x < 0 || x >= C || y < 0 || y >= R;
    }
}

class P {
    int x;
    int y;

    public P(int y, int x) {
        this.x = x;
        this.y = y;
    }
}