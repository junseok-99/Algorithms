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

        visited[y][x] = -1; //방문했음을 체크
        int ty = y;
        int tx = x;
        char dir = map[y][x];
        if (dir == 'D') ty++;
        else if (dir == 'R') tx++;
        else if (dir == 'U') ty--;
        else if (dir == 'L') tx--;

        return visited[y][x] = dfs(ty, tx);
    }
}