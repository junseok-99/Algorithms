import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            int number = Integer.parseInt(st.nextToken());
            if (isPrime(number)) ++answer;
        }
        System.out.println(answer);
    }

    public static boolean isPrime(int number) {
        if (number == 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}