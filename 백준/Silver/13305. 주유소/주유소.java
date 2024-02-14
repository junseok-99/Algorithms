import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static Set<Integer> set;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dist = new int[N - 1];
        int[] cost = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        int minCost = cost[0];
        int sumOil = dist[0] * cost[0];

        for (int i = 1; i < N - 1; i++) {
            if (cost[i] < minCost) {
                minCost = cost[i];
            }
            sumOil += dist[i] * minCost;
        }
        System.out.println(sumOil);
    }
}