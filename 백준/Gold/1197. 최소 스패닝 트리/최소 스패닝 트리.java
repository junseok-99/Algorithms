import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int V;
    static int E;
    static int[] parents;
    static List<Node> nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V + 1];
        nodes = new ArrayList<>();

        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodes.add(new Node(u, v, w));
        }

        Collections.sort(nodes);
        int answer = 0;

        for (Node node : nodes) {
            if (find(node.s) == find(node.d)) continue;
            union(node.s, node.d);
            answer += node.w;
        }
        System.out.println(answer);
    }

    public static void union(int v1, int v2) {
        int root1 = find(v1);
        int root2 = find(v2);

        if (root1 < root2) parents[root2] = root1;
        else parents[root1] = root2;
    }

    public static int find(int v) {
        if (parents[v] != v) {
            return parents[v] = find(parents[v]);
        }
        return v;
    }
}

class Node implements Comparable<Node>{
    int s;
    int d;
    int w;

    public Node(int s, int d, int w) {
        this.s = s;
        this.d = d;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.w, o.w);
    }
}