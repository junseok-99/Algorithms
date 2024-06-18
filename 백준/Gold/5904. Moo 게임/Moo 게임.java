import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(moo(n));
    }

    public static String moo(int n) {
        int size = 3;
        int idx = 0;

        if (n == 1) {
            return "m";
        } else if (n <= 3) {
            return "o";
        } else {
            while (size < n) {
                size = size * 2 + idx + 4;
                idx++;
            }

            int fb = (size - idx - 3) / 2;

            if (size - fb + 1 <= n) return moo(n - size + fb);
            else if (n == fb + 1) return "m";
            else return "o";
        }
    }
}