import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int answer;
    static NodeInfo[] nodes;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        answer = Integer.MIN_VALUE;
        nodes = new NodeInfo[N + 1];
        visited = new boolean[N + 1];
        
        if (N == 1) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeN = Integer.parseInt(st.nextToken());
            int neighborN = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (nodes[nodeN] == null) nodes[nodeN] = new NodeInfo();
            if (nodes[neighborN] == null) nodes[neighborN] = new NodeInfo();

            nodes[nodeN].addNode(new Node(neighborN, weight));
            nodes[neighborN].addNode(new Node(nodeN, weight));
        }

        for (int i = 1; i <= N; i++) {
            dfs(i, 0);
        }
        System.out.println(answer);
    }

    public static void dfs(int nextNode, int weightSum) {
        if (visited[nextNode]) return;
        answer = Math.max(answer, weightSum);

        visited[nextNode] = true;

        for (Node node : nodes[nextNode].nodes) {
            dfs(node.number, weightSum + node.weight);
        }

        visited[nextNode] = false;
    }
}

class Node {
    int number;
    int weight;

    public Node(int number, int weight) {
        this.number = number;
        this.weight = weight;
    }
}

class NodeInfo {
    List<Node> nodes;

    public NodeInfo() {
        nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }
}