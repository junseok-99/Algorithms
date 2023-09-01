import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int start = n / 5;
        int rem = n % 5;

        while (rem % 2 != 0) {
            if (start == 0) {
                System.out.println(-1);
                return;
            }
            start--;
            rem += 5;
        }

        System.out.println(start + (rem / 2));


    }

}
