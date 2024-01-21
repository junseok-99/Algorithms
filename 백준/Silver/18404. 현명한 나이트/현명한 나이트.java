import java.io.*;
import java.util.*;

public class Main {

    private static List<Point> enemies = new ArrayList<Point>();
    private static int[] answer;
    private static int[][] map;
    private static boolean[][] visited;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][N];
        map = new int[N][N];
        answer = new int[M];
        st = new StringTokenizer(br.readLine());
        int nightY = Integer.parseInt(st.nextToken()) - 1;
        int nightX = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int enemyY = Integer.parseInt(st.nextToken()) - 1;
            int enemyX = Integer.parseInt(st.nextToken()) - 1;
            map[enemyY][enemyX] = 1;
            enemies.add(new Point(enemyX, enemyY));
        }

        bfs(nightY, nightX);

        for (int i = 0; i < M; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
        bw.close();
    }

    public static void bfs(int nightY, int nightX) {
        Deque<Point> q = new ArrayDeque<Point>();
        int[] jumpX = {-1, -1, 1, 1, -2, -2, 2, 2};
        int[] jumpY = {2, -2, 2, -2, 1, -1, 1, -1};

        visited[nightY][nightX] = true;
        q.addLast(new Point(nightX, nightY));

        while (!q.isEmpty()) {
            Point p = q.pollFirst();

            if (map[p.y][p.x] == 1) {
                map[p.y][p.x] = 0;
//                System.out.println(p.y + " " + p.x + " " + p.dist);
                for (int i = 0; i < enemies.size(); i++) {
                    int ex = enemies.get(i).x;
                    int ey = enemies.get(i).y;
                    if (p.compare(ey, ex)) {
                        answer[i] += p.dist;
                    }
                }
            }
            for (int i = 0; i < 8; i++) {
                int tx = p.x + jumpX[i];
                int ty = p.y + jumpY[i];
                if (validRange(ty, tx)) {
                    continue;
                }

                if (!visited[ty][tx]) {
                    q.add(new Point(tx, ty, p.dist + 1));
                    visited[ty][tx] = true;
                }
            }
        }
    }

    public static boolean validRange(int y, int x) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }
}

class Point {
    int x;
    int y;
    int dist;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.dist = 0;
    }

    public Point(int x, int y, int dist) {
        this(x, y);
        this.dist = dist;
    }

    public boolean compare(int ey, int ex) {
        return (this.x == ex) && (this.y == ey);
    }
}