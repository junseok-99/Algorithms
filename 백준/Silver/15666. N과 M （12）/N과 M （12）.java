import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        sb = new StringBuilder();
        set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0, 0, "");

        System.out.println(sb);
    }

    public static void dfs(int depth, int idx, String s) {
        if (depth == M) {
            if (set.contains(s)) return;
            sb.append(s).append('\n');
            set.add(s);
            return;
        }

        for (int i = idx; i < N; i++) {
            dfs(depth + 1, i, s + arr[i] + " ");
        }
    }
}