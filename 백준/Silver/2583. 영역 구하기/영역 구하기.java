import java.io.*;
import java.util.*;

public class Main{

    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;

        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j=x1;j<x2;j++) {
                for(int k=y1;k<y2;k++) {
                    map[k][j] = -1;
                    visited[k][j] = true;
                }
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                if (!visited[i][j]) {
                    ++cnt;
                    pq.add(bfs(i, j, M, N));
                }
            }
        }

        System.out.println(cnt);
        for(int i=0;i<cnt;i++) {
            System.out.printf("%d ", pq.poll());
        }
    }

    public static int bfs(int y, int x, int M, int N) {
        int cnt = 1;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new int[]{y,x});

        while (!q.isEmpty()) {
            int[] point = q.poll();

            for(int i=0;i<4;i++) {
                int tx = point[1] + dx[i];
                int ty = point[0] + dy[i];

                if (tx < 0 || tx >= N || ty < 0 || ty >= M) {
                    continue;
                }
                if (!visited[ty][tx]) {
                    visited[ty][tx] = true;
                    q.add(new int[]{ty, tx});
                    cnt++;
                }
            }
        }
        return cnt;
    }

}