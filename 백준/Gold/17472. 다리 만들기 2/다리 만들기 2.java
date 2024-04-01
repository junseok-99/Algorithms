import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static int allIslandCount = 1;
    static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;
    static List<Edge> edgeList = new ArrayList<Edge>();
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        //맵 초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //섬 라벨링
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    labeling(i, j);
                    allIslandCount++;
                }
            }
        }
        makeEdgeList();

        Collections.sort(edgeList);
        makeSet();

        int cnt = 0;
        int weightSum = 0;
        for (Edge edge : edgeList) {
            int a = edge.source;
            int b = edge.destination;
            int weight = edge.weight;
            if (union(a, b)) {
                weightSum += weight;
                ++cnt;
            }

            if (cnt == allIslandCount) break;
        }

        for (int i = 1; i <= allIslandCount; i++) {
            parents[i] = find(i);
        }
        for (int i = 1; i <= allIslandCount; i++) {
            if (parents[i] != parents[1]) {
                weightSum = -1;
                break;
            }
        }
        System.out.println(weightSum);
    }

    public static void makeSet() {
        allIslandCount--;
        parents = new int[allIslandCount + 1];
        for (int i = 1; i <= allIslandCount; i++) {
            parents[i] = i;
        }
    }

    public static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) return false;
        if (parentA > parentB) parents[parentA] = parentB;
        else if (parentA < parentB) parents[parentB] = parentA;
        return true;
    }

    public static int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    public static void makeEdgeList() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) continue;

                for (int k = 0; k < 4; k++) {
                    int tr = i + d[k][0];
                    int tc = j + d[k][1];
                    if (invalidRange(tr, tc) || map[tr][tc] != 0) continue;
                    installEdge(tr, tc, map[i][j], 0, k);
                }
            }
        }
    }

    public static void installEdge(int r, int c, int source, int weight, int dir) {
        if (map[r][c] > 0) {
            if (weight >= 2) edgeList.add(new Edge(source, map[r][c], weight));
            return;
        }

        int tr = r + d[dir][0];
        int tc = c + d[dir][1];
        if (invalidRange(tr, tc)) return;

        installEdge(tr, tc, source, weight + 1, dir);
    }

    public static void labeling(int r, int c) {
        if (visited[r][c]) return;

        visited[r][c] = true;
        map[r][c] = allIslandCount;

        for (int i = 0; i < 4; i++) {
            int tr = r + d[i][0];
            int tc = c + d[i][1];

            if (invalidRange(tr, tc) || map[tr][tc] == 0) continue;
            labeling(tr, tc);
        }
    }

    public static boolean invalidRange(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= M;
    }
}

class Edge implements Comparable<Edge> {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}
