import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int taesu = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int[] grades = new int[P];

        int rank = 1;
        int cnt = 0;
        int before = -1;

        Arrays.fill(grades, -1);

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            grades[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < P; i++) {
            if (grades[i] < taesu) {
                System.out.println(rank + cnt);
                return;
            } else if (grades[i] == taesu) {
                continue;
            }

            if (before == grades[i]) {
                cnt++;
            } else {
                rank += cnt;
                rank++;
                cnt = 0;
            }
            before = grades[i];
        }
        System.out.println(-1);
    }
}
