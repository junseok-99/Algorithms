import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int K;
    static int[] times;
    static int[] completeTimes;
    static int[] tailCnts;
    static List<List<Integer>> nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            times = new int[N + 1];
            completeTimes = new int[N + 1];
            tailCnts = new int[N + 1];
            nodes = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i <= N; i++) {
                nodes.add(new ArrayList<>());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                nodes.get(s).add(d);
                tailCnts[d]++;
            }

            int buildNumber = Integer.parseInt(br.readLine());

            topologySort();
            sb.append(completeTimes[buildNumber]).append('\n');
        }
        System.out.println(sb);
    }

    public static void topologySort() {
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (tailCnts[i] == 0) {
                q.add(i);
                completeTimes[i] = times[i];
            }
        }

        while (!q.isEmpty()) {
            int num = q.poll();

            for (int child : nodes.get(num)) {
                tailCnts[child]--;
                if (tailCnts[child] == 0) q.add(child);
                completeTimes[child] = Math.max(completeTimes[child], completeTimes[num] + times[child]);
            }
        }
    }
}