import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int M;
    static int L;
    static int[][] map;
    static int[][][] dir = {
            {{0, -1}, {0, 1}, {-1, 0}, {1, 0}},
            {{0, -1}, {0, 1}},
            {{-1, 0}, {1, 0}},
            {{0, -1}, {1, 0}},
            {{0, 1}, {1, 0}},
            {{0, 1}, {-1, 0}},
            {{0, -1}, {-1, 0}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            Point manholeP = new Point(R, C);

            //지도 초기화
            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = bfs(manholeP);
            sb.append("#").append(tc).append(' ').append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static int bfs(Point startP) {
        Deque<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        visited[startP.r][startP.c] = true;
        q.add(startP);

        int answer = 0;
        while (L-- > 0) {
            int size = q.size();
            answer += size;

            if (size == 0) break;
            while (size-- > 0) {
                Point p = q.poll();
                int type = map[p.r][p.c] - 1;
                if (type == -1) continue;

                for (int i = 0; i < dir[type].length; i++) {
                    int tc = p.c + dir[type][i][0];
                    int tr = p.r + dir[type][i][1];

                    if (tc < 0 || tc >= M || tr < 0 || tr >= N || visited[tr][tc])
                        continue;
                    if (map[tr][tc] == 0) continue;

                    int movedManholeType = map[tr][tc] - 1;
                    int oppositeC = dir[type][i][0] * -1;
                    int oppositeR = dir[type][i][1] * -1;
                    for (int j = 0; j < dir[movedManholeType].length; j++) {
                        if (oppositeC == dir[movedManholeType][j][0] && oppositeR == dir[movedManholeType][j][1]) {
                            visited[tr][tc] = true;
                            q.add(new Point(tr, tc));
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
}

class Point {
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}