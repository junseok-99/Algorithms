import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int K;
    static int R;
    static List<Point>[][] roads;
    static boolean[][] map;
    static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static boolean[][] checked1; //다리 안건너고 만날 수 있는지
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        roads = new ArrayList[N][N];
        map = new boolean[N][N];
        checked1 = new boolean[K][K];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                roads[i][j] = new ArrayList<>();
            }
        }

        //다리 초기화
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;
            roads[r1][c1].add(new Point(r2, c2));
            roads[r2][c2].add(new Point(r1, c1));
        }

        //소 초기화
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = true;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j]) bfs(i, j);
            }
        }

        System.out.println(answer / 2);
    }

    //다리를 안건너고 만나보기
    public static void bfs(int r, int c) {
        Deque<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        visited[r][c] = true;
        q.add(new Point(r, c));
        int cnt = 0;

        while (!q.isEmpty()) {
            Point cp = q.poll();

            for (int i = 0; i < 4; i++) {
                int tr = cp.r + d[i][0];
                int tc = cp.c + d[i][1];

                if (invalidRange(tr, tc) || visited[tr][tc]) continue;

                boolean isRoad = false;
                for (Point tp : roads[cp.r][cp.c]) {
                    if (tp.r == tr && tp.c == tc) {
                        isRoad = true;
                        break;
                    }
                }
                if (isRoad) continue;
                if (map[tr][tc]) ++cnt;

                q.add(new Point(tr, tc));
                visited[tr][tc] = true;
            }
        }
        answer += (K - cnt - 1);
    }

    public static boolean invalidRange(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= N;
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