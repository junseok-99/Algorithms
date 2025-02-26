import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean flag;
    static boolean[] visited;
    static int[] picked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        visited = new boolean[9];
        picked = new int[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        combi(0, 0, "", 0);
    }

    public static void combi(int idx, int depth, String s, int sum) {
        if (sum == 100 && depth == 7) {
            flag = true;
            System.out.println(s);
            return;
        }

        for (int i = idx; i < 9 && !flag; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            combi(i + 1, depth + 1, s + arr[i] + "\n", sum + arr[i]);
            visited[i] = false;
        }
    }
}