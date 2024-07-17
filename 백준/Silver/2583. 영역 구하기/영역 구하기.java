import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int M;
    static int N;
    static int K;
    static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    visited[k][j] = true;
                }
            }
        }

        int areaCount = 0;


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    ++areaCount;
                    bfs(i, j);
                }
            }
        }
        Collections.sort(list);

        sb.append(areaCount + "\n");
        for (int number : list) {
            sb.append(number + " ");
        }
        System.out.println(sb);
    }

    public static boolean invalidRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }
    public static void bfs(int y, int x) {
        Deque<Pos> q = new ArrayDeque<>();
        q.add(new Pos(y, x));
        int size = 0;
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Pos p = q.poll();
            ++size;

            for (int i = 0; i < 4; i++) {
                int tx = p.x + d[i][0];
                int ty = p.y + d[i][1];

                if (invalidRange(tx, ty) || visited[ty][tx]) continue;
                visited[ty][tx] = true;
                q.add(new Pos(ty, tx));
            }
        }
        list.add(size);
    }
}

class Pos {
    int x;
    int y;

    public Pos(int y, int x) {
        this.x = x;
        this.y = y;
    }
}