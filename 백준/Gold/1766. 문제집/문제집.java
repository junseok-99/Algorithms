import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static List<List<Integer>> questions;
    static int[] parents;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        questions = new ArrayList<>();
        sb = new StringBuilder();

        for (int i = 0; i <= N; i++) {
            questions.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            parents[v]++;
            questions.get(u).add(v);
        }

        tpSort();
        System.out.println(sb);
    }

    public static void tpSort() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            if (parents[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int n = pq.poll();
            sb.append(n).append(" ");

            for (int child : questions.get(n)) {
                parents[child]--;

                if (parents[child] == 0) {
                    pq.add(child);
                }
            }
        }
    }
}