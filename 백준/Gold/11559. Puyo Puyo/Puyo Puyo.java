import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    static char[][] map = new char[12][6];
    static boolean[][] visited;
    static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int answer = 0;
        while (true) {
            visited = new boolean[12][6];
            boolean flag = false;

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.' && !visited[i][j]) {
                        List<P> pointList = bfs(i, j);

                        if (!pointList.isEmpty()) {
                            flag = true;
                        }
                        for (P p : pointList) {
                            map[p.r][p.c] = '*';
                        }
                    }
                }
            }

            for (int i = 0; i < 6; i++) {
                Deque<Character> q = new ArrayDeque<>();
                for (int j = 11; j >= 0; j--) {
                    if (Character.isLetter(map[j][i])) {
                        q.add(map[j][i]);
                    }
                }
                int mid = 11 - q.size();
                for (int j = 11; j > mid; j--) {
                    map[j][i] = q.poll();
                }

                for (int j = mid; j >= 0; j--) {
                    map[j][i] = '.';
                }
            }

            if (!flag) break;
            ++answer;
        }
        System.out.println(answer);
    }

    public static List<P> bfs(int r, int c) {
        Deque<P> q = new ArrayDeque<P>();
        visited[r][c] = true;
        q.add(new P(r, c));
        char color = map[r][c];
        int cnt = 0;
        List<P> pointList = new ArrayList<>();

        while (!q.isEmpty()) {
            P p = q.poll();
            pointList.add(p);
            ++cnt;

            for (int i = 0; i < 4; i++) {
                int tr = p.r + d[i][0];
                int tc = p.c + d[i][1];

                if (invalidRange(tr, tc) || visited[tr][tc] || map[tr][tc] != color) {
                    continue;
                }

                visited[tr][tc] = true;
                q.add(new P(tr, tc));
            }
        }
        if (cnt < 4) pointList.clear();
        return pointList;
    }

    public static boolean invalidRange(int r, int c) {
        return r < 0 || r >= 12 || c < 0 || c >= 6;
    }
}

class P {
    int r;
    int c;

    public P(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public String toString() {
        return "P{" +
                "r=" + r +
                ", c=" + c +
                '}';
    }
}