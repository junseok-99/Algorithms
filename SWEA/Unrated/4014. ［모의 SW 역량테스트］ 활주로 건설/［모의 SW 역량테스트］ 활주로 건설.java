import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int X;
    static int[][] map;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            answer = 0;

            //맵 초기화
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //row 확인
            for (int i = 0; i < N; i++) {
                int[] road = new int[N];
                System.arraycopy(map[i], 0, road, 0, N);
                constructor(road);
            }

            //col 확인
            for (int i = 0; i < N; i++) {
                int[] road = new int[N];
                for (int j = 0; j < N; j++) {
                    road[j] = map[j][i];
                }
                constructor(road);
            }
            sb.append("#").append(tc).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }

    public static void constructor(int[] road) {
        boolean[] isConstructor = new boolean[N];

        int idx = 0;
        while (idx < N - 1) {
            int subHeight = road[idx + 1] - road[idx];

            if (subHeight == 1) {
                for (int i = idx; i >= idx - X + 1; i--) {
                    if (invalidRange(i) || road[i] != road[idx] || isConstructor[i]) return;
                    isConstructor[i] = true;
                }
                idx++;
            } else if (subHeight == -1) {
                for (int i = idx + 1; i <= idx + X; i++) {
                    if (invalidRange(i) || road[i] != road[idx + 1] || isConstructor[i]) return;
                    isConstructor[i] = true;
                }
                idx += X;
            } else if (subHeight == 0) {
                idx++;
            }else {
                return;
            }
        }
        ++answer;
    }

    public static boolean invalidRange(int x) {
        return x < 0 || x >= N;
    }
}