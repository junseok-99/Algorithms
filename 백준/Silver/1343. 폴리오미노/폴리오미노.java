import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] board = br.readLine().toCharArray();
        int cnt = 0;
        StringBuilder answer = new StringBuilder();

        for(char c: board) {
            if (c == '.') {
                if (cnt > 0) {
                    if(convert(answer, cnt)) {
                        return;
                    };
                }
                answer.append(".");
                cnt = 0;
            } else {
                ++cnt;
            }
        }

        if (cnt > 0) {
            if (convert(answer, cnt)) {
                return;
            }
        }
        System.out.println(answer.toString());
    }

    public static boolean convert(StringBuilder sb, int cnt) {
        sb.append("AAAA".repeat(cnt / 4));

        int rem = cnt % 4;

        if (rem % 2 == 0) {
            sb.append("BB".repeat(rem / 2));
            return false;
        }
        System.out.println("-1");
        return true;
    }

}
