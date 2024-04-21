import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = new char[N];
        int red = 0;
        int blue = 0;

        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == 'R') red++;
            else if (s.charAt(i) == 'B') blue++;
            arr[i] = s.charAt(i);
        }

        int answer = Integer.MAX_VALUE;
        int tmp = 0;

        //빨강이 맨 왼쪽으로
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'R') ++tmp;
            else break;
        }
        answer = Integer.min(answer, red - tmp);

        tmp = 0;
        //파랑이 맨 왼쪽으로
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'B') ++tmp;
            else break;
        }
        answer = Integer.min(answer, blue - tmp);

        tmp = 0;
        //빨강이 맨 오른쪽으로
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] == 'R') ++tmp;
            else break;
        }
        answer = Integer.min(answer, red - tmp);

        tmp = 0;
        //파랑이 맨 오른쪽으로
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] == 'B') ++tmp;
            else break;
        }
        answer = Integer.min(answer, blue - tmp);

        System.out.println(answer);
    }
}