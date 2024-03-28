import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int t;
    static int[] parents;
    static List<Info> li = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            li.add(new Info(a, b, w));
        }
        Collections.sort(li);

        int cnt = 0;
        int answer = 0;
        for (Info info : li) {
            if (find(info.s) == find(info.d)) continue;
            if (union(info.s, info.d)) {
                answer += (info.weight + t * cnt);
                cnt++;
            }
        }
        System.out.println(answer);
    }

    public static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) return false;
        if (parentA > parentB) parents[parentA] = parentB;
        if (parentA < parentB) parents[parentB] = parentA;
        return true;
    }

    public static int find(int n) {
        if (parents[n] == n) {
            return n;
        }
        return parents[n] = find(parents[n]);
    }
}

class Info implements Comparable<Info> {
    int s;
    int d;
    int weight;

    public Info(int s, int d, int weight) {
        this.s = s;
        this.d = d;
        this.weight = weight;
    }

    @Override
    public int compareTo(Info o) {
        return Integer.compare(this.weight, o.weight);
    }
}