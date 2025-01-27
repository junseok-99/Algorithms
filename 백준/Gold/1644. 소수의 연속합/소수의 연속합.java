import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> sosu = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            if (isSosu(i)) sosu.add(i);
        }
        sosu.add(0);
        int l = 0, r = 0, sum = 0;
        int answer = 0;
        while (l <= r && r < sosu.size()) {
            if (sum < N) sum += sosu.get(r++);
            else {
                if (sum == N) ++answer;
                sum -= sosu.get(l++);
            }
        }
        System.out.println(answer);
    }

    public static boolean isSosu(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}