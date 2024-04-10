import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static List<P> virusList = new ArrayList<>();
    static int blankCnt;
    static int[] picked;
    static int answer = Integer.MAX_VALUE;
    static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        picked = new int[M];

        //Init
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) ++blankCnt;
                else if (map[i][j] ==2) virusList.add(new P(j, i));
            }
        }

        if (blankCnt == 0) {
            System.out.println(0);
            return;
        }

        combi(0, 0);
        if (answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }

    public static int bfs() {
        int time = 0;
        Deque<P> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        int cnt = 0;

        for (int i = 0; i < M; i++) {
            P p = virusList.get(picked[i]);
            q.add(p);
            visited[p.y][p.x] = true;
        }

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                P p = q.poll();

                for (int i = 0; i < 4; i++) {
                    int tx = p.x + d[i][0];
                    int ty = p.y + d[i][1];
                    if (invalidRange(tx, ty) || visited[ty][tx] || map[ty][tx] == 1) continue;

                    if (map[ty][tx] == 0) ++cnt;
                    q.add(new P(tx, ty));
                    visited[ty][tx] = true;
                }
            }
            ++time;
            if (cnt == blankCnt) break;
        }
        if (cnt == blankCnt) return time;
        return Integer.MAX_VALUE;
    }

    public static boolean invalidRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }

    public static void combi(int idx, int depth) {
        if (depth == M) {
            answer = Math.min(answer, bfs());
            return;
        }

        for (int i = idx; i < virusList.size(); i++) {
            picked[depth] = i;
            combi(i + 1, depth + 1);
        }
    }
}

class P {
    int x;
    int y;

    public P(int x, int y) {
        this.x = x;
        this.y = y;
    }
}