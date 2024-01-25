import java.io.*;
import java.util.*;

public class Main {

    private static int[][] map;
    private static int N;
    private static int M;
    private static int[] cctvDirections = {-1, 1, 2, 2, 3, 4};
    private static int[] cctvCases = {-1, 4, 2, 4, 4, 1};
    private static List<Cctv> cctvList = new ArrayList<>();
    private static List<Integer> list = new LinkedList<>();
    //[0] = y, [1] = x
    private static int[][][] delta = {
            {{0, -1}, {0, 1}, {-1, 0}, {1, 0}},
            {{0, 1}, {0, -1}, {-1, 0}, {1, 0}},
            {{-1, 0}, {0, 1}, {1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}, {0, -1}},
            {{0, -1}, {0, 1}, {-1, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 0}},
            {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}
    };
    private static int answer = Integer.MAX_VALUE;
    private static int[][] copyMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;

                if (0 < n && n < 6) {
                    cctvList.add(new Cctv(new Point(i, j), n));
                }
            }
        }

        backTracking(0);

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    public static int[][] makeCopyMap() {
        int[][] tmp = new int[N][M];
        for (int i =0; i < N; i++) {
            System.arraycopy(map[i], 0, tmp[i], 0, M);
        }
        return tmp;
    }

    public static void dfs(int y, int x, int dy, int dx) {
        int tx = x + dx;
        int ty = y + dy;

        if (tx < 0 || tx >= M || ty < 0 || ty >= N) {
            return;
        }

        if (copyMap[ty][tx] <= 5) {
            copyMap[ty][tx] = -1;
            dfs(ty, tx, dy, dx);
        }
    }


    public static void backTracking(int depth) {
        if (depth == cctvList.size()) {
            copyMap = makeCopyMap();
            for (int i = 0; i < depth; i++) {
                int y = cctvList.get(i).point.y;
                int x = cctvList.get(i).point.x;

                int cctvNum = cctvList.get(i).num;
                int start = list.get(i) * cctvDirections[cctvNum];
                int end = start + cctvDirections[cctvNum];
                for (int j = start; j < end; j++) {
                    dfs(y, x, delta[cctvNum - 1][j][0], delta[cctvNum - 1][j][1]);
                }
            }
            answer = Math.min(answer, calcBlindSpot());
            return;
        }

        int maxCaseNum = cctvCases[cctvList.get(depth).num];
        for (int i = 0; i < maxCaseNum; i++) {
            list.add(i);
            backTracking(depth + 1);
            list.remove(depth);
        }
    }

    public static int calcBlindSpot() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    ++cnt;
                }
            }
        }
        return cnt;
    }
}

class Cctv {
    Point point;
    int num;

    public Cctv(Point point, int num) {
        this.point = point;
        this.num = num;
    }
}

class Point {
    int x;
    int y;

    public Point(int y, int x) {
        this.x = x;
        this.y = y;
    }
}