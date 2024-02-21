import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//
public class Main {

    private static List<List<Integer>> friends = new ArrayList<>();
    private static boolean[] visited;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            friends.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends.get(a).add(b);
            friends.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
        	visited = new boolean[N];
            dfs(i, 0, N);
            if (answer == 1) {
                break;
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int node, int depth, int N) {
        if (depth >= 4) {
            answer = 1;
            return;
        }

        for (int friend : friends.get(node)) {
            if (!visited[friend]) {
            	visited[node] = true;
                dfs(friend, depth + 1, N);
                visited[node] = false;
            }
        }
    }
}