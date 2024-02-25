import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            char[] birds = new char[N];
            sb.append("#").append(tc).append(' ');

            //앵무새 초기화
            for (int i = 0; i < N; i++) {
                birds[i] = br.readLine().charAt(0);
            }

            int l = 0;
            int r = N - 1;

            while (l <= r) {
                if (birds[l] > birds[r]) {
                    sb.append(birds[r--]);
                } else if (birds[l] < birds[r]) {
                    sb.append(birds[l++]);
                } else {
                    int tmpL = l;
                    int tmpR = r;
                    while (tmpL < tmpR) {
                        if (birds[tmpL] != birds[tmpR]) break;
                        tmpL++;
                        tmpR--;
                    }

                    if (birds[tmpL] > birds[tmpR]) {
                        sb.append(birds[r--]);
                    } else if (birds[tmpL] <= birds[tmpR]) {
                        sb.append(birds[l++]);
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}