import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        TreeSet<Problem> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            set.add(new Problem(P, L));
            map.put(P, L);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String action = st.nextToken();

            if (action.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());

                set.add(new Problem(P, L));
                map.put(P, L);
            } else if (action.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());

                if (x == 1) {
                    sb.append(set.first().P);
                } else if (x == -1) {
                    sb.append(set.last().P);
                }
                sb.append("\n");
            } else if (action.equals("solved")) {
                int P = Integer.parseInt(st.nextToken());
                set.remove(new Problem(P, map.get(P)));
                map.remove(P);
            }
        }
        System.out.println(sb);
    }
}

class Problem implements Comparable<Problem> {
    int P;
    int L;

    public Problem(int p, int l) {
        P = p;
        L = l;
    }

    @Override
    public int compareTo(Problem o) {
        if (this.L == o.L) {
            return o.P - this.P;
        }
        return o.L - this.L;
    }
}