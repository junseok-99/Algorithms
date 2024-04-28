import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Star[] stars = new Star[K];

        //init starDDong
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars[i] = new Star(x, y);
        }

        int answer = -1;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                int cnt = 0;
                for (int k = 0; k < K; k++) {
                    if (stars[i].x <= stars[k].x && stars[k].x <= stars[i].x + L
                        && stars[j].y <= stars[k].y && stars[k].y <= stars[j].y + L) {
                        ++cnt;
                    }
                }
                answer = Math.max(answer, cnt);
            }
        }
        System.out.println(K - answer);
    }
}

class Star {
    int x;
    int y;

    public Star(int x, int y) {
        this.x = x;
        this.y = y;
    }
}