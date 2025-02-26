import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        System.out.println(fibo(N));
    }

    public static int fibo(int N) {
        if (N == 0 || N == 1) return N;
        return fibo(N - 1) + fibo(N - 2);
    }
}