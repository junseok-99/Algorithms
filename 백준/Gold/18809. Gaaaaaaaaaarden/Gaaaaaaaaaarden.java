import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int G;
    static int R;
    static int[][] map;
    static List<P> soilList = new ArrayList<>();
    static boolean[] visitedSoil;
    static P[] pickGreens;
    static P[] pickReds;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        pickGreens = new P[G];
        pickReds = new P[R];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    soilList.add(new P(j, i));
                }
            }
        }
        visitedSoil = new boolean[soilList.size()];
        combiGreen(0, 0);
        System.out.println(answer);
    }
    
    public static void bfs() {
        int[][] d = {{-1 ,0}, {1, 0}, {0, -1}, {0, 1}};
        Deque<P> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int[][] tmpMap = new int[N][M]; //1: green, 2: red, 3: flower
        int flower = 0;

        for (int i = 0; i < G; i++) {
            int x = pickGreens[i].x;
            int y = pickGreens[i].y;
            q.add(new P(x, y, 1));
            visited[y][x] = true;
            tmpMap[y][x] = 1;
        }

        for (int i = 0; i < R; i++) {
            int x = pickReds[i].x;
            int y = pickReds[i].y;
            q.add(new P(x, y, 2));
            visited[y][x] = true;
            tmpMap[y][x] = 2;
        }

        while (!q.isEmpty()) {
            int size = q.size();
            Deque<P> tmpQ = new ArrayDeque<>();

            while (size-- > 0) {
                P p = q.poll();
//                System.out.println(p);
                for (int i = 0; i < 4; i++) {
                    int tx = p.x + d[i][0];
                    int ty = p.y + d[i][1];

                    if (invalidRange(tx, ty)) continue;
                    if (map[ty][tx] == 0) continue;

                    if (!visited[ty][tx] && tmpMap[ty][tx] == 0) {
                        tmpMap[ty][tx] += p.color;
                        visited[ty][tx] = true;
                        tmpQ.add(new P(tx, ty, p.color));
                    }
                    if (visited[ty][tx] && (tmpMap[ty][tx] + p.color == 3)) {
                        tmpMap[ty][tx] += p.color;
                    }

//                    for (int j = 0; j < N; j++) {
//                        System.out.println(Arrays.toString(tmpMap[j]));
//                    }
//                    System.out.println();
                }
            }

            while (!tmpQ.isEmpty()) {
                P p = tmpQ.poll();
                if (tmpMap[p.y][p.x] == 3) ++flower;
                else q.add(p);
            }
        }
//        System.out.println("------------------------------------");
        answer = Math.max(answer, flower);
    }

    public static void combiGreen(int start, int depth) {
        if (depth == G) {
            combiRed(0, 0);
            return;
        }
        for (int i = start; i < soilList.size(); i++) {
            visitedSoil[i] = true;
            pickGreens[depth] = soilList.get(i);
            combiGreen(i + 1, depth + 1);
            visitedSoil[i] = false;
        }
    }

    public static void combiRed(int start, int depth) {
        if (depth == R) {
            bfs();
//            System.out.print(Arrays.toString(pickGreens) + " , ");
//            System.out.println(Arrays.toString(pickReds));
//            System.out.println("-----------------");
            return;
        }
        for (int i = start; i < soilList.size(); i++) {
            if (visitedSoil[i]) continue;
            pickReds[depth] = soilList.get(i);
            combiRed(i + 1, depth + 1);
        }
    }

    public static boolean invalidRange(int x, int y) {
        return x < 0 || x >= M || y < 0 || y >= N;
    }
}

class P {
    int x;
    int y;
    int color;

    public P(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public P(int x, int y, int color) {
        this(x, y);
        this.color = color;
    }

    @Override
    public String toString() {
        return "P{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}