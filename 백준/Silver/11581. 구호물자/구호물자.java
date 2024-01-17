import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<List<Integer>> map = new ArrayList<>();
    private static boolean[] visited;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 1; i <= N - 1; i++) {
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int connectedNode = Integer.parseInt(st.nextToken());
                map.get(i).add(connectedNode);
            }
        }
        dfs(1);
        System.out.println("NO CYCLE");
    }

    public static void dfs(int node) {
        if (node == N) {
            return;
        }

        for (int connectedNode : map.get(node)) {
            if (visited[connectedNode]) {
                System.out.println("CYCLE");
                System.exit(0);
            }
            visited[connectedNode] = true;
            dfs(connectedNode);
            visited[connectedNode] = false;
        }
    }
}
