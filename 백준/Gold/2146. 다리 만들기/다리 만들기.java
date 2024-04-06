import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int islandCnt = 1;
    static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    floodFill(i, j);
                    ++islandCnt;
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0) {
                    boolean flag = false;
                    for (int k = 0; k < 4; k++) {
                        int tx = j + d[k][0];
                        int ty = i + d[k][1];
                        if (invalidRange(ty, tx) || map[ty][tx] != 0) continue;
                        flag = true;
                    }

                    if (flag) {
                        answer = Math.min(answer, bfs(i, j));
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static int bfs(int y, int x) {
        Deque<Pos> q =new ArrayDeque<>();
        visited = new boolean[N][N];
        visited[y][x] = true;
        q.add(new Pos(y, x));
        int curNum = map[y][x];
        int dist = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pos p = q.poll();
                if (map[p.y][p.x] > 0 && map[p.y][p.x] != curNum) {
                    return dist;
                }
                for (int i = 0; i < 4; i++) {
                    int tx = p.x + d[i][0];
                    int ty = p.y + d[i][1];

                    if (invalidRange(ty, tx) || visited[ty][tx] || map[ty][tx] == curNum) continue;
                    visited[ty][tx] = true;
                    q.add(new Pos(ty, tx));
                }
            }
            dist++;
        }
        return Integer.MAX_VALUE;
    }

    public static void floodFill(int y, int x) {
        Deque<Pos> q =new ArrayDeque<>();
        visited[y][x] = true;
        q.add(new Pos(y, x));

        while (!q.isEmpty()) {
            Pos p = q.poll();
            map[p.y][p.x] = islandCnt;

            for (int i = 0; i < 4; i++) {
                int tx = p.x + d[i][0];
                int ty = p.y + d[i][1];

                if (invalidRange(ty, tx) || visited[ty][tx] || map[ty][tx] == 0) continue;
                visited[ty][tx] = true;
                q.add(new Pos(ty, tx));
            }
        }
    }

    public static boolean invalidRange(int y, int x) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }
}

class Pos {
    int x;
    int y;

    Pos (int y, int x) {
        this.x = x;
        this.y = y;
    }
}