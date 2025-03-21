import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static char[] ops;
    static boolean[] visited;
    static int max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        ops = new char[N - 1];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        visited = new boolean[N - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                ops[idx++] = changeOperator(i);
            }
        }

        permu(0, arr[0]);
        System.out.println(max + "\n" + min);
    }

    public static void permu(int depth, int result) {
        if (depth == N - 1) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            permu(depth + 1, changeExpression(result, arr[depth + 1], ops[i]));
            visited[i] = false;
        }
    }

    public static int changeExpression(int a, int b, char op) {
        if (op == '+') return a + b;
        else if (op == '-') return a - b;
        else if (op == '*') return a * b;
        else if (op == '/') return a / b;
        return -1;
    }

    public static char changeOperator(int i) {
        if (i == 0) return '+';
        else if (i == 1) return '-';
        else if (i == 2) return '*';
        else if (i == 3) return '/';
        return 'ㅗ';
    }
}