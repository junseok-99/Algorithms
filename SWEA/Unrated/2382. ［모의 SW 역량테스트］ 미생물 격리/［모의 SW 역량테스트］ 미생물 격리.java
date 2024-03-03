import java.io.*;
import java.util.*;

public class Solution {

    static int answer;
    static Maps[][] map;
    static int N;
    static int M;
    static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            answer = 0;
            N = Integer.parseInt(st.nextToken());
            map = new Maps[N][N];
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            //구역 초기화
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = new Maps();
                }
            }

            //군집 초기화
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int microBug = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                int[] dirArr = Arrays.copyOf(dir[d - 1], 2);
                map[r][c].add(new Gunzip(microBug, dirArr));
            }

            moveGunzip();

            sb.append("#").append(tc).append(' ').append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void moveGunzip() {
        while (M-- > 0) {
            Maps[][] copyMap = new Maps[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    copyMap[i][j] = new Maps();

            //군집 이동
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j].isEmpty()) continue;
                    map[i][j].move(copyMap, i, j, N);
                }
            }

            //군집 합치기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (copyMap[i][j].size() < 2) continue;
                    copyMap[i][j].union();
                }
            }

            map = copyMap;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].isEmpty()) continue;
                answer += map[i][j].livedMicoBug();
            }
        }
    }
}

class Maps {
    List<Gunzip> list;

    Maps() {
        list = new ArrayList<>();
    }

    public void move(Maps[][] map, int r, int c, int N) {
        for (Gunzip gunzip : list) {
            int tc = c + gunzip.dir[0];
            int tr = r + gunzip.dir[1];

            //방향 전환
            if (isBound(tr, tc, N)) {
                gunzip.killMicroBug();
                gunzip.changeDir();
            }

            //미생물이 다 죽으면
            if (gunzip.isDie()) continue;

            map[tr][tc].add(gunzip);
        }
    }

    public int livedMicoBug() {
        int microBugSum = 0;
        for (Gunzip gunzip : list) {
            microBugSum += gunzip.microBug;
        }
        return microBugSum;
    }

    public void union() {
        int microBugSum = livedMicoBug();
        Collections.sort(list);
        int[] dir = list.get(0).dir;

        list.clear();
        list.add(new Gunzip(microBugSum, dir));
    }

    public void add(Gunzip gunzip) {
        list.add(gunzip);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    //약품이 칠해진 곳인지
    public boolean isBound(int r, int c, int N) {
        return r == 0 || r == N - 1 || c == 0 || c == N - 1;
    }
}

class Gunzip implements Comparable<Gunzip> {
    int microBug; //미생물 수
    int[] dir;

    public Gunzip(int microBug, int[] dir) {
        this.microBug = microBug;
        this.dir = dir;
    }

    public void killMicroBug() {
        microBug /= 2;
    }

    public boolean isDie() {
        return microBug == 0;
    }

    public void changeDir() {
        dir[0] *= -1;
        dir[1] *= -1;
    }

    @Override
    public int compareTo(Gunzip o) {
        return Integer.compare(o.microBug, this.microBug);
    }
}