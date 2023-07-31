import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int left = N / 10;
        int right = N % 10;
        int sum = right * 10 + (left+right) % 10;
        int cnt = 1;

        while(sum != N) {
            left = sum / 10;
            right = sum % 10;
            sum = right * 10 + (left+right) % 10;
            cnt++;
        }
        System.out.println(cnt);
    }
}
