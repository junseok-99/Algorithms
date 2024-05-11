import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int isConnect = Integer.parseInt(st.nextToken());
                if (i == j || isConnect == 0) continue;

                union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int lastParent = find(Integer.parseInt(st.nextToken()) - 1);
        for (int i = 1; i < M; i++) {
            int n = Integer.parseInt(st.nextToken()) - 1;
            if (lastParent != find(n)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA < parentB) {
            parents[parentB] = parentA;
        } else if (parentA > parentB) {
            parents[parentA] = parentB;
        }
    }

    public static int find(int node) {
        if (parents[node] == node) {
            return node;
        }
        return parents[node] = find(parents[node]);
    }
}