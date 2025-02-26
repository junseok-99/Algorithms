import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            searchBinaryNumber(N, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void searchBinaryNumber(int N, int depth) {
        if (N % 2 == 1) sb.append(depth).append(" ");
        if (N / 2 == 0) {
            return;
        }
        searchBinaryNumber(N / 2, depth + 1);
    }
}