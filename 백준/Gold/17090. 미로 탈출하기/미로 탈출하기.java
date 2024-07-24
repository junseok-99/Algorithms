import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static boolean[][] visited;
    static int[][] countMap;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        countMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (countMap[i][j] != 1 && countMap[i][j] != -1) {
                    dfs(i, j);
                }
            }
        }

        int escapeSum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (countMap[i][j] == 1) {
                    ++escapeSum;
                }
            }
        }
        System.out.println(escapeSum);
    }

    public static int dfs(int r, int c) {
        if (invalidRange(r, c) || countMap[r][c] == 1) {
            return 1;
        }
        if (visited[r][c] || countMap[r][c] == -1) {
            return -1;
        }

        Pos pos = getPos(map[r][c]);
        int tr = r + pos.r;
        int tc = c + pos.c;

        visited[r][c] = true;
        countMap[r][c] = dfs(tr, tc);
        visited[r][c] = false;

        return countMap[r][c];
    }

    public static Pos getPos(char c) {
        switch (c) {
            case 'U':
                return new Pos(-1, 0);
            case 'R':
                return new Pos(0, 1);
            case 'D':
                return new Pos(1, 0);
            case 'L':
                return new Pos(0, -1);
        }
        return null;
    }

    public static boolean invalidRange(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= M;
    }
}

class Pos {
    int r;
    int c;

    public Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }
}