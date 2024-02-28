import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static boolean[][] map;
    static int[][] numMap;
    static int N;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; //좌, 하, 우, 상
    static List<Core> cores;
    static int answer;
    static int maxCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new boolean[N][N];
            numMap = new int[N][N];
            cores = new ArrayList<>();
            maxCnt = 0;
            answer = Integer.MAX_VALUE;

            //멕시노스 초기화
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int n = Integer.parseInt(st.nextToken());
                    if (n == 1) map[i][j] = true;
                }
            }

            //가장자리에 없는 Core의 전선을 깔 수 있는 경우의 수 찾기
            searchLine();

            //백트래킹 시작
            backTracking(0, 0, 0);
            sb.append("#").append(tc).append(' ').append(answer).append("\n");
        }
        System.out.println(sb);
    }

    //전선 깔기
    public static int installLine(int n, int x, int y, int dir, int depth) {
        if (dir == -1) return 0;

        numMap[y][x] = n;
        int tx = x + d[dir][0];
        int ty = y + d[dir][1];
        if (invalidRange(tx, ty)) {
            return depth;
        }

        return installLine(n, tx, ty, dir, depth + 1);
    }

    //core를 설치할 수 있는지
    public static boolean checkInstall(int x, int y, int dir) {
        if (dir == -1 || invalidRange(x, y)) return true;
        if (numMap[y][x] != 0) return false;

        int tx = x + d[dir][0];
        int ty = y + d[dir][1];
        return checkInstall(tx, ty, dir);
    }

    //Core들이 전선을 까는 경우의 수 돌리기
    public static void backTracking(int depth, int lengthSum, int cntSum) {
        if (depth == cores.size()) {
            if (maxCnt <= cntSum) {
                if (maxCnt != cntSum) {
                    answer = lengthSum;
                    maxCnt = cntSum;
                }
                answer = Math.min(answer, lengthSum);
            }
            return;
        }

        for (int dir : cores.get(depth).dirList) {
            int x = cores.get(depth).x;
            int y = cores.get(depth).y;

            if (!checkInstall(x, y, dir)) continue;
            int length = installLine(depth + 1, x, y, dir, 0);
            int cnt = dir != -1 ? 1 : 0;
            backTracking(depth + 1, lengthSum + length, cntSum + cnt);
            installLine(0, x, y, dir, 0);
        }
    }

    //가장자리에 없는 Core의 전선을 깔 수 있는 경우의 수 찾기
    public static void searchLine() {
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (map[i][j]) {
                    Core core = new Core(j, i);
                    for (int k = 0; k < 4; k++) {
                        dfs(j, i, k, core);
                    }

                    if (!core.isEmpty()) {
                        cores.add(core);
                    }
                }
            }
        }
    }

    //현재 Core가 전선을 깔 수 있는지 확인
    public static void dfs(int x, int y, int dir, Core core) {
        int tx = x + d[dir][0];
        int ty = y + d[dir][1];

        if (invalidRange(tx, ty)) {
            core.addDir(dir);
            return;
        }

        if (!map[ty][tx])
            dfs(tx, ty, dir, core);
    }

    public static boolean invalidRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }
}

class Core {
    int x;
    int y;
    List<Integer> dirList;

    Core(int x, int y) {
        this.x = x;
        this.y = y;
        dirList = new ArrayList<>();
        dirList.add(-1);
    }

    public void addDir(int dir) {
        this.dirList.add(dir);
    }

    public boolean isEmpty() {
        return dirList.size() == 1;
    }

    public String toString() {
        return dirList.toString();
    }
}