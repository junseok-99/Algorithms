import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static char[][] map;
    static int[][] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new int[N][M];

        if (N == 1 && M == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }
        System.out.println(cnt);
    }

    public static int dfs(int y, int x) {
        if (visited[y][x] == -1) { //없던 사이클 방문
            return ++cnt;
        } else if (visited[y][x] > 0) { //이미 있던 사이클 방문
            return visited[y][x];
        }

        visited[y][x] = -1;
        char dir = map[y][x];
        if (dir == 'D') visited[y][x] = dfs(y + 1, x);
        else if (dir == 'R') visited[y][x] = dfs(y, x + 1);
        else if (dir == 'U') visited[y][x] = dfs(y - 1, x);
        else if (dir == 'L') visited[y][x] = dfs(y, x - 1);

        return visited[y][x];
    }
}