import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int t;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] parents;
    static PriorityQueue<Info> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);

            pq.add(new Info(a, b, w));
        }

        int cnt = 0;
        long answer = 0;
        while (cnt < N) {
            Deque<Info> q = new ArrayDeque<>();

            while (true) {
                Info info = pq.poll();

                if ((find(info.s) == 1 || find(info.d) == 1) && (isJungbok(info.s) || isJungbok(info.d))) {
                    if (union(info.s, info.d)) {
                        answer += (long)(info.weight + t * cnt);
                        cnt++;
                        break;
                    }
                } else {
                    q.add(info);
                }

            }
            if (cnt == N - 1) break;
            while (!q.isEmpty()) {
                pq.add(q.poll());
            }
        }
        System.out.println(answer);
    }

    public static boolean isJungbok(int a) {
        for (int n : list.get(a)) {
            if (find(n) == 1) return true;
        }
        return false;
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