import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static int R;
    static int C;
    static Deque<P> iceQ = new ArrayDeque<>();
    static Deque<P> birdQ = new ArrayDeque<>();
    static P endP;
    static boolean[][] visited;
    static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'L') {
                    if (birdQ.isEmpty()) {
                        birdQ.add(new P(i, j));
                        visited[i][j] = true;
                    } else {
                        endP = new P(i, j);
                    }
                    iceQ.add(new P(i, j));
                } else if (map[i][j] == '.') {
                    iceQ.add(new P(i, j));
                }
            }
        }

        int answer = 0;
        while (!isMeet()) {
            melt();
            answer++;
        }
        System.out.println(answer);
    }

    public static boolean isMeet() {
        Deque<P> tmpQ = new ArrayDeque<>();

        while (!birdQ.isEmpty()) {
            P birdP = birdQ.poll();

            for (int i = 0; i < 4; i++) {
                int tx = birdP.x + d[i][0];
                int ty = birdP.y + d[i][1];

                if (invalidRange(tx, ty) || visited[ty][tx]) continue;
                visited[ty][tx] = true;

                if (endP.isSamePoint(tx, ty)) {
                    return true;
                }

                if (map[ty][tx] == 'X') {
                    tmpQ.add(new P(ty, tx));
                } else {
                    birdQ.add(new P(ty, tx));
                }
            }
        }
        birdQ = tmpQ;
        return false;
    }

    public static void melt() {
        int size = iceQ.size();

        while (size-- > 0) {
            P iceP = iceQ.poll();

            for (int i = 0; i < 4; i++) {
                int tx = iceP.x + d[i][0];
                int ty = iceP.y + d[i][1];

                if (invalidRange(tx, ty)) continue;

                if (map[ty][tx] == 'X') {
                    map[ty][tx] = '.';
                    iceQ.add(new P(ty, tx));
                }
            }
        }
    }

    public static boolean invalidRange(int x, int y) {
        return x < 0 || x >= C || y < 0 || y >= R;
    }
}

class P {
    int x;
    int y;

    P(int y, int x) {
        this.x = x;
        this.y = y;
    }

    public boolean isSamePoint(int x, int y) {
        return (this.x == x) && (this.y == y);
    }
}