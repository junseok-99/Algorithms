import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = "";
        while ((in = br.readLine()) != null) {
            int n = (int) Math.pow(3, Integer.parseInt(in));
            System.out.println(recur(n, n, "-".repeat(n)));
        }
    }

    public static String recur(int len, int n, String s) {
        if (n == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i+=(n/3)) {
            if (i % 2 == 0) {
                sb.append(s.substring(i, i + n/3));
            } else {
                sb.append(" ".repeat(n/3));
            }
        }
        return recur(len,n / 3, sb.toString());
    }

}
