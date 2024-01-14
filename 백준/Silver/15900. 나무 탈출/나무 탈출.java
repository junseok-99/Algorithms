import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static List<List<Integer>> tree = new ArrayList<>();
    private static boolean[] visited;
    private static int depthSum = 0;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        initTree(N);
        visited[1] = true;

        for (int childOfRoot : tree.get(1)) {
            dfs(childOfRoot, 1);
        }

        if (depthSum % 2 != 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void initTree(int N) throws IOException {
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
    }

    public static void dfs(int node, int depth) {
        visited[node] = true;

        if (tree.get(node).size() == 1) { //Leaf Node
            depthSum += depth;
            return;
        }

        for (int child : tree.get(node)) {
            if (!visited[child]){
                dfs(child, depth + 1);
            }
        }
    }
}