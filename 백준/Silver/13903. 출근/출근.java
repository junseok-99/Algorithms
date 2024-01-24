import java.io.*;
import java.util.*;

public class Main {

    private static int[][] map;
    private static boolean[][] visited;
    private static List<Integer> dx = new ArrayList<Integer>();
    private static List<Integer> dy = new ArrayList<Integer>();
    private static int R;
    private static int C;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dy.add(Integer.parseInt(st.nextToken()));
            dx.add(Integer.parseInt(st.nextToken()));
        }

        bw.write(bfs(0) + "");
        bw.flush();
        bw.close();
    }

    public static int bfs(int row) {
        Deque<Person> q = new ArrayDeque<>();

        for (int i = 0; i < C; i++) {
            if (map[row][i] == 1) {
                q.addLast(new Person(i, row, 0));
                visited[row][i] = true;
            }
        }

        while (!q.isEmpty()) {
            Person p = q.pollFirst();
            if (p.y == R - 1) {
                return p.dist;
            }

            for (int i = 0; i < N; i++) {
                int tx = p.x + dx.get(i);
                int ty = p.y + dy.get(i);

                if (tx < 0 || tx >= C || ty < 0 || ty >= R) {
                    continue;
                }

                if (!visited[ty][tx] && map[ty][tx] == 1) {
                    q.addLast(new Person(tx, ty, p.dist + 1));
                    visited[ty][tx] = true;
                }
            }
        }
        return -1;
    }
}

class Person {
    int x;
    int y;
    int dist;

    public Person(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}