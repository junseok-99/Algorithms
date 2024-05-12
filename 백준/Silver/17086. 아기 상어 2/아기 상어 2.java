import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static boolean[][] map;
    static boolean[][] visited;
    static int answer = Integer.MIN_VALUE;
    static int[][] d = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1) map[i][j] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!map[i][j]) {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }

        System.out.println(answer);
    }

    public static int bfs(int r, int c) {
        Deque<Shark> q = new ArrayDeque<>();
        q.add(new Shark(r, c, 0));
        visited = new boolean[N][M];
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Shark shark = q.poll();

            for (int i = 0; i < 8; i++) {
                int tr = shark.r + d[i][0];
                int tc = shark.c + d[i][1];

                if (invalidRange(tr, tc) || visited[tr][tc]) continue;

                if (map[tr][tc]) return shark.dist + 1;
                q.add(new Shark(tr, tc, shark.dist + 1));
                visited[tr][tc] = true;
            }
        }
        return -1;
    }

    public static boolean invalidRange(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= M;
    }
}

class Shark {
    int r;
    int c;
    int dist;

    public Shark(int r, int c, int dist) {
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}