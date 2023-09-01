import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] levels = new int[N];

        for(int i=0;i<N;i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        for(int i=N-2;i>-1;i--) {
            while (levels[i] >= levels[i+1]) {
                levels[i]--;
                answer++;
            }
        }

        System.out.println(answer);
    }

}
