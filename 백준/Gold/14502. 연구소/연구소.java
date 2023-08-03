import java.util.*;


public class Main {

    private static int[][] map;
    private static int answer = -1;

    public static class Pos {
        int x;
        int y;

        Pos(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
    public static void dfs(int depth, int n, int m) {
        if (depth == 3) {
            answer = Math.max(answer,bfs(n,m));
            return;
        }

        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth + 1, n, m);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static int bfs(int n, int m) {
        Queue<Pos> q = new LinkedList<>();
        int[][] tmp = new int[n][m];
        boolean[][] v = new boolean[n][m];

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int cnt = 0;

        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) q.add(new Pos(i, j));
                else if(map[i][j] == 0) ++cnt;

                tmp[i][j] = map[i][j];
            }
        }

        while(!q.isEmpty()) {
            Pos p = q.poll();
            int tx, ty;
            for(int i=0;i<4;i++) {
                tx = p.x + dx[i];
                ty = p.y + dy[i];
                if(-1 < tx && tx < m && -1 < ty && ty < n && tmp[ty][tx] == 0 && !v[ty][tx]) {
                    q.add(new Pos(ty,tx));
                    tmp[ty][tx] = 2;
                    v[ty][tx] = true;
                    --cnt;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        map = new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                map[i][j] = scan.nextInt();

        dfs(0,n,m);
        System.out.println(answer);

    }
}
