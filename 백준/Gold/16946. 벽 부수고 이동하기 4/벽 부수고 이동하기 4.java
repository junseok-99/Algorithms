import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static int[][] spaceMap;
    static int spaceCnt = 1;
    static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        spaceMap = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    bfs(j, i);
                    spaceCnt++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    int cnt = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int tx = j + d[k][0]  ;
                        int ty = i + d[k][1];
                        if (invalidRange(tx, ty) || !visited[ty][tx] || set.contains(spaceMap[ty][tx])) continue;
                        set.add(spaceMap[ty][tx]);
                        cnt += map[ty][tx];
                    }
                    map[i][j] = cnt % 10;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) sb.append(0);
                else sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int x, int y) {
        Deque<P> q = new ArrayDeque<>();
        Deque<P> tmpQ = new ArrayDeque<>();
        q.add(new P(x, y));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            P p = q.poll();
            spaceMap[p.y][p.x] = spaceCnt;
            tmpQ.add(p);

            for (int i = 0; i < 4; i++) {
                int tx = p.x + d[i][0];
                int ty = p.y + d[i][1];

                if (invalidRange(tx, ty) || visited[ty][tx] || map[ty][tx] == 1) continue;
                visited[ty][tx] = true;
                q.add(new P(tx, ty));
            }
        }

        int size = tmpQ.size();
        while (!tmpQ.isEmpty()) {
            P p = tmpQ.poll();
            map[p.y][p.x] = size;
        }
    }

    public static boolean invalidRange(int x, int y) {
        return x < 0 || x >= M || y < 0 || y >= N;
    }
}

class P {
    int x;
    int y;

    P(int x, int y) {
        this.x = x;
        this.y = y;
    }
}