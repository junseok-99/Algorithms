import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (M <= N) {
            if (isPrime(M)) {
                    sum += M;
                    min = Math.min(min, M);
            }
            M++;
        }
        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(sum + "\n" + min);
    }

    public static boolean isPrime(int N) {
        if (N == 1) return false;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) return false;
        }
        return true;
    }
}