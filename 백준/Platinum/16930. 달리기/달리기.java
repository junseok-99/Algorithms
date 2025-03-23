import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int K;
    static char[][] map;
    static int[][] visited;
    static int sr, sc, er, ec;
    static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            Arrays.fill(visited[i], -1);
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;
        er = Integer.parseInt(st.nextToken()) - 1;
        ec = Integer.parseInt(st.nextToken()) - 1;

        bfs(sr, sc, er, ec);
        System.out.println(visited[er][ec]);
    }

    public static void bfs(int sr, int sc, int er, int ec) {
        Deque<Point> q = new ArrayDeque<>();
        q.add(new Point(sr, sc));
        visited[sr][sc] = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                for (int k = 1; k <= K; k++) {
                    int tr = p.r + d[i][0] * k;
                    int tc = p.c + d[i][1] * k;

                    if (invalidRange(tr, tc) || map[tr][tc] == '#') break;

                    if (visited[tr][tc] == -1) visited[tr][tc] = visited[p.r][p.c] + 1;
                    else if (visited[tr][tc] <= visited[p.r][p.c]) break;
                    else if (visited[tr][tc] == visited[p.r][p.c] + 1) continue;

                    visited[tr][tc] = visited[p.r][p.c] + 1;
                    if (tr == er && tc == ec) return;

                    q.add(new Point(tr, tc));
                }
            }
        }
    }

    public static boolean invalidRange(int tr, int tc) {
        return tr < 0 || tr >= N || tc < 0 || tc >= M;
    }
}

class Point {
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}