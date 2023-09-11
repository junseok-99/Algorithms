import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int time;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        time = 0;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            removeIceMountain();
            visited = new boolean[n][m];
            int answer = 0;

            for(int i=1;i<n-1;i++) {
                for(int j=1;j<m-1;j++) {
                    if (!visited[i][j] && map[i][j] > 0) {
                        dfs(i, j);
                        ++answer;
                    }
                }
            }

            ++time;

            if (answer == 0) {
                System.out.println(0);
                break;
            }

            if (answer >= 2) {
                System.out.println(time);
                break;
            }


        }

    }

    public static void removeIceMountain() {
        int[][] copyMap = new int[n][m];

        for(int i=0;i<n;i++) {
            copyMap[i] = map[i].clone();
        }

        for(int i=1;i<n-1;i++) {
            for(int j=1;j<m-1;j++) {
                int cnt = 0;

                if (map[i][j] > 0) {
                    for (int k = 0; k < 4; k++) {
                        int tx = j + dx[k];
                        int ty = i + dy[k];

                        if (map[ty][tx] == 0) {
                            ++cnt;
                        }
                    }
                    copyMap[i][j] = map[i][j] - cnt < 0 ? 0 : map[i][j] - cnt;
                }
            }
        }

        map = copyMap;
    }

    public static void dfs(int y, int x) {
        if (!visited[y][x]) {
            visited[y][x] = true;

            for(int i=0;i<4;i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];

                if (tx < 0 || tx == m || ty < 0 || ty == n) {
                    continue;
                }

                if (map[ty][tx] > 0) {
                    dfs(ty, tx);
                }
            }
        }
    }

}
