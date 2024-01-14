import java.io.*;
import java.util.*;

public class Main {

    public static class Node {
        int num;
        int left;
        int right;
        public Node(int num, int left, int right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.num + " ");
            sb.append(this.left + " ");
            sb.append(this.right + "\n");
            return sb.toString();
        }
    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static boolean[] visited;
    private static List<List<Integer>> tree = new ArrayList<>();
    private static PriorityQueue<Node> answer = new PriorityQueue<>((node1, node2) -> {return node1.num - node2.num;});
    private static int cnt = 1;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        initTree(N);
        int root = Integer.parseInt(br.readLine());

        dfs(root);

        outputAnswer();
    }

    public static void initTree(int N) throws IOException {
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int root = Integer.parseInt(st.nextToken());
            while (true) {
                int nodeNum = Integer.parseInt(st.nextToken());
                if (nodeNum == -1) {
                    break;
                }
                tree.get(root).add(nodeNum);
            }
            Collections.sort(tree.get(root));
        }
    }

    public static void dfs(int nodeNum) {
        int left = -1;
        int right = -1;

        visited[nodeNum] = true;
        left = cnt++;

        for (int child : tree.get(nodeNum)) {
            if (!visited[child]) {
                dfs(child);
            }
        }
        right = cnt++;
        answer.add(new Node(nodeNum, left, right));
    }

    public static void outputAnswer() throws IOException {
        while (!answer.isEmpty()) {
            bw.write(answer.poll() + "");
        }
        bw.flush();
        bw.close();
    }
}