import java.io.*;
import java.util.*;

public class Main{

    static int[][] countries;
    static boolean[][] visited;
    static Stack<int[]> changeCoords = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        countries = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                countries[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while (true) {
            boolean flag = false;
            visited = new boolean[N][N];

            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if (!visited[i][j]) {
                        int n = countries[i][j];
                        int ret = bfs(N, L, R, i, j);

                        if (changeCoords.size() > 1) {
                            while (!changeCoords.isEmpty()) {
                                int[] coord = changeCoords.pop();
                                countries[coord[0]][coord[1]] = ret;
                                flag = true;
                            }
                        }
                        changeCoords.clear();
                    }
                }
            }

            if (!flag) {
                System.out.println(answer);
                break;
            }

            answer++;
        }

    }

    public static int bfs(int N, int L, int R, int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        changeCoords.push(new int[]{y,x});
        visited[y][x] = true;
        int cnt = 1;
        int sum = 0;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while (!q.isEmpty()) {
            int[] coord = q.poll();
            sum += countries[coord[0]][coord[1]];

            for(int i=0;i<4;i++) {
                int tx = coord[1] + dx[i];
                int ty = coord[0] + dy[i];

                if (tx < 0 || tx >= N || ty < 0 || ty >= N) {
                    continue;
                }

                if (!visited[ty][tx]) {
                    int diff = Math.abs((countries[coord[0]][coord[1]] - countries[ty][tx]));
                    if (diff >= L && diff <= R) {
                        visited[ty][tx] = true;
                        cnt++;
                        q.add(new int[]{ty, tx});
                        changeCoords.push(new int[]{ty, tx});
                    }
                }
            }
        }
        return sum / cnt;
    }

}