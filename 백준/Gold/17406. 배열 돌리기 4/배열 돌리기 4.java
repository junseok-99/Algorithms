import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//mem: 35,704kb	time: 232ms
public class Main {

    static int[][] map;
    static SpinFlag[] flags;
    static boolean[] visited;
    static int[] idxs;
    static int N;
    static int M;
    static int K;
    static int answer;
    static int[][] delta = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        flags = new SpinFlag[K];
        visited = new boolean[K];
        idxs = new int[K];

        //배열 초기화
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = Integer.MAX_VALUE;

        //회전 위치 초기화
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            flags[i] = new SpinFlag(r, c, s);
        }

        permu(0);

        System.out.println(answer);
    }

    public static void dfs(int y, int x, Pos startP, int dir, int[][] copyMap) {
        if (dir == 4) {
            return;
        }
        int num = copyMap[y][x];
        int tx = x + delta[dir][0];
        int ty = y + delta[dir][1];

        if (startP.inValidRange(ty, tx)) {
            dir++;
            dfs(y, x,startP, dir, copyMap);
        } else {
            dfs(ty, tx, startP, dir, copyMap);
            copyMap[ty][tx] = num;
        }
    }

    public static void spin() {
        int[][] copyMap = makeCopyArr();

        for (int i = 0; i < K; i++) {
            SpinFlag sFlag = flags[idxs[i]];
            for (int j = 1; j <= sFlag.s; j++) {
                Pos startP = new Pos(sFlag, j);
                dfs(startP.startY, startP.startX, startP, 0, copyMap);
            }
        }
        answer = Math.min(answer, minSumOfArray(copyMap));
    }

    public static int minSumOfArray(int[][] arr) {
        int minSum = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= M; j++) {
                sum += arr[i][j];
            }
            minSum = Math.min(minSum, sum);
        }
        return minSum;
    }

    public static int[][] makeCopyArr() {
        int[][] tmp = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            tmp[i] = Arrays.copyOf(map[i], M + 1);
        }
        return tmp;
    }

    //순열을 통해 회전 순서 만들기
    public static void permu(int depth) {
        if (depth == K) {
            spin();
            return;
        }

        for (int i = 0; i < K; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            idxs[depth] = i;
            permu(depth + 1);
            visited[i] = false;
        }
    }
}

class SpinFlag {
    int r;
    int c;
    int s;

    public SpinFlag(int r, int c, int s) {
        this.r = r;
        this.c = c;
        this.s = s;
    }
}

class Pos {
    int startY;
    int startX;
    int endY;
    int endX;

    public Pos(int startY, int startX, int endY, int endX) {
        this.startY = startY;
        this.startX = startX;
        this.endY = endY;
        this.endX = endX;
    }

    public Pos(SpinFlag sFlag, int s) {
        this.startY = sFlag.r - s;
        this.startX = sFlag.c - s;
        this.endY = sFlag.r + s;
        this.endX = sFlag.c + s;
    }

    public boolean inValidRange(int ty, int tx) {
        return tx < this.startX || tx > this.endX || ty < this.startY || ty > this.endY;
    }
}