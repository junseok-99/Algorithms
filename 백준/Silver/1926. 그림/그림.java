import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int size;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int answer = 0;
        int maxSize = 0;
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    size = 0;
                    dfs(i, j, 0);
                    maxSize = Math.max(maxSize, size);
                    ++answer;
                }
            }
        }

        System.out.println(answer);
        System.out.println(maxSize);
    }

    public static void dfs(int y, int x, int num) {

        visited[y][x] = true;
        ++size;

        for(int i=0;i<4;i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];

            if (tx < 0 || tx == m || ty < 0 || ty == n) {
                continue;
            }

            if (!visited[ty][tx] && map[ty][tx] == 1) {
                dfs(ty, tx, num);
            }
        }
    }

}
