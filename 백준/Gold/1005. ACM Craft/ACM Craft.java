import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static List<List<Integer>> child;
    static int[] weight, complete, indeg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            weight = new int[N + 1];
            complete = new int[N + 1];
            indeg = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
            }

            child = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                child.add(new ArrayList<>());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                child.get(c).add(p);
                indeg[p]++;
            }

            int building = Integer.parseInt(br.readLine());

            tpSort();

            sb.append(complete[building]).append('\n');
        }
        System.out.println(sb);
    }

    public static void tpSort() {
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                complete[i] = weight[i];
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : child.get(x)) {
                indeg[y]--;
                if (indeg[y] == 0) q.add(y);
                complete[y] = Math.max(complete[y], complete[x] + weight[y]);

            }
        }
    }
}