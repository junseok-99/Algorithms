import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int mapLength = (int)Math.pow(2, N);

        segment(mapLength, 0, 0, 0);
    }

    public static void segment(int n, int sum, int tr, int tc) {
        int r = n / 2; // 분할된 사각형 너비
        int size = r * r;
        int cnt = 0;

        if (n == 2) {
            z(tr, tc, sum, 0);
            return;
        }

        for (int i = tr; i < tr + n; i += r) {
            for (int j = tc; j < tc + n; j += r, cnt++) {
                if (i <= R && R < i + r && j <= C && C < j + r) {
                    segment(r, cnt * size + sum, i, j);
                    return;
                }
            }
        }
    }

    public static void z(int curR, int curC, int num, int flag) {
        if (curR == R && curC == C) {
            System.out.println(num);
            return;
        }

        if (flag == 0) {
            z(curR, curC + 1, num + 1, 1);
        } else if (flag == 1) {
            z(curR + 1, curC - 1, num + 1, 2);
        } else if (flag == 2) {
            z(curR, curC + 1, num + 1, 3);
        }
    }
}