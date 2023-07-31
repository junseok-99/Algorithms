import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] path = new int[N];
        float len = Integer.parseInt(st.nextToken());
        int answer = 0;

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            path[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(path);

        float start = (float)path[0] - 0.5f;
        for(int i=0;i<N;i++) {
            if(start <= path[i] && path[i] <= start+len) {
                continue;
            }
            start = (float)path[i] - 0.5f;
            ++answer;
        }

        System.out.println(answer+1);
    }
}
