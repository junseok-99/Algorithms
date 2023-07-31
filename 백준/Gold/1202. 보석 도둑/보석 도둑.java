import java.io.*;
import java.util.*;

/**
 * 백준 1202번 보석 도둑
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] jews = new int[N][2];
        int[] bagWeights = new int[K];
        PriorityQueue<int[]> jewsInBag = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        long maxJewelry = 0;

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            jews[i][0] = Integer.parseInt(st.nextToken());
            jews[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<K;i++) {
            bagWeights[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jews, (o1, o2) -> o1[0] - o2[0]);
        Arrays.sort(bagWeights);

        int j = 0;
        for(int i=0;i<K;i++) {
            while(j < N && jews[j][0] <= bagWeights[i]) {
                jewsInBag.add(jews[j++]);
            }

            if(!jewsInBag.isEmpty()) {
                maxJewelry += (long)(jewsInBag.poll()[1]);
            }
        }

        System.out.println(maxJewelry);
    }
}
