import java.io.*;
import java.util.*;

/**
 * 백준 1049번 기타줄
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int pkgN;

        if(N % 6 == 0) {
            pkgN = N / 6;
        } else {
            pkgN = (N/6) + 1;
        }

        int minPkg = Integer.MAX_VALUE;
        int minSingle = Integer.MAX_VALUE;

        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int pkg = Integer.parseInt(st.nextToken());
            int single = Integer.parseInt(st.nextToken());;
            minPkg = Math.min(minPkg, pkg);
            minSingle = Math.min(minSingle, single);
        }

        int answer = -1;

        answer = Math.min(minPkg * pkgN , Math.min(minSingle * N, minPkg * (N / 6) + minSingle * (N % 6)));
        System.out.println(answer);
    }
}