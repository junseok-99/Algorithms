import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (true) {
            if (isPrime(N) && isPalindrome(N)) {
                System.out.println(N);
                break;
            }
            N++;
        }
    }

    public static boolean isPrime(int N) {
        if (N <= 1) return false;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) return false;
        }
        return true;
    }

    public static boolean isPalindrome(int N) {
        String strN = Integer.toString(N);
        int len = strN.length();

        for (int i = 0; i < len / 2; i++) {
            if (strN.charAt(i) != strN.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}