import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int maxCnt = Integer.MIN_VALUE;
        int trainCnt = 0;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());

            trainCnt -= out;
            trainCnt += in;
            maxCnt = Math.max(maxCnt, trainCnt);
        }
        System.out.println(maxCnt);
    }
}