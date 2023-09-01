import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] weis = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            weis[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weis);

        int sum = 0;

        for(int i=0;i<N;i++) {
            if (sum + 1 < weis[i]) {
                break;
            }
            sum += weis[i];
        }
        System.out.println(sum+1);
    }

}
