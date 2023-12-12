import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] heights = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(heights);

        for (int i=0;i<N;i++) {
            if (heights[i] > L) {
                break;
            }
            L++;
        }

        System.out.println(L);
    }


}