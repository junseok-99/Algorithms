import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i=1;i<=1000000;i++) {
            int sum = i;
            int tmp = i;
            if (N <= i) {
                break;
            }
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }

            if (sum == N) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

}
