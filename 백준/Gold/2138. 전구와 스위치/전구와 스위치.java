import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String bs = br.readLine();
        String as = br.readLine();

        char[] before = bs.toCharArray();
        char[] after = as.toCharArray();
        char[] before2 = bs.toCharArray();
        change(before2, 0);

        int n1 = 0;
        int n2 = 1;
        for (int i = 1; i < N; i++) {
            if (before[i - 1] != after[i - 1]) {
                n1++;
                change(before, i);
            }
            if (before2[i - 1] != after[i - 1]) {
                n2++;
                change(before2, i);
            }
        }

        int answer = Integer.MAX_VALUE;
        if (as.equals(new String(before))) {
            answer = Math.min(answer, n1);
        }
        if (as.equals(new String(before2))) {
            answer = Math.min(answer, n2);
        }
        if (answer == Integer.MAX_VALUE) {
            answer = - 1;
        }
        System.out.println(answer);
    }

    public static void change(char[] switchs, int n) {
        if (n - 1 > -1) {
            switchs[n - 1] = switchs[n - 1] == '0' ? '1' : '0';
        }
        switchs[n] = switchs[n] == '0' ? '1' : '0';
        if (n + 1 < N) {
            switchs[n + 1] = switchs[n + 1] == '0' ? '1' : '0';
        }
    }
}