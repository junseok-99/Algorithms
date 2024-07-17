import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static long answer = 0;
    static int[] accumulateA;
    static int[] accumulateB;
    static Map<Integer, Long> mapA = new HashMap<>();
    static Map<Integer, Long> mapB = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        accumulateA = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            accumulateA[i] = number;

            if (i > 0) accumulateA[i] += accumulateA[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            mapA.put(accumulateA[i], mapA.getOrDefault(accumulateA[i], 0L) + 1L);
            for (int j = i - 1; j >= 0; j--) {
                int sum = accumulateA[i] - accumulateA[j];
                mapA.put(sum , mapA.getOrDefault(sum, 0L) + 1L);
            }
        }

        int m = Integer.parseInt(br.readLine());
        accumulateB = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(st.nextToken());
            accumulateB[i] = number;

            if (i > 0) accumulateB[i] += accumulateB[i - 1];
        }

        for (int i = m - 1; i >= 0; i--) {
            mapB.put(accumulateB[i], mapB.getOrDefault(accumulateB[i], 0L) + 1);
            for (int j = i - 1; j >= 0; j--) {
                int sum = accumulateB[i] - accumulateB[j];
                mapB.put(sum , mapB.getOrDefault(sum, 0L) + 1);
            }
        }

        for (int number : mapA.keySet()) {
            int needNumber = T - number;
            answer += mapA.getOrDefault(number, 0L) * mapB.getOrDefault(needNumber, 0L);
        }
        System.out.println(answer);
    }
}