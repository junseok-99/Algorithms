import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static boolean flag;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        backTrack(0, "");

        if (!flag) System.out.println(-1);
    }

    public static void backTrack(int sum, String s) {
        if (sum > n || flag) return;
        if (sum == n) {
            k--;
            if (k == 0) {
                flag = true;
                System.out.println(s.substring(1));
                return;
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            backTrack(sum + i, s + "+" + i);
        }
    }
}