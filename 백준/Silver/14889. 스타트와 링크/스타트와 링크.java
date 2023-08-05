import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] stat;
    private static boolean[] visited;
    private static int answer = Integer.MAX_VALUE;

    public static void calcRecord(int N) {

        int startSum = 0;
        int linkSum = 0;

        for(int i=0;i<N-1;i++) {
            for(int j=i+1;j<N;j++) {
                if (i != j) {
                    if (visited[i] == true && visited[j] == true) {
                        startSum += stat[i][j];
                        startSum += stat[j][i];
                    } else if (visited[i] == false && visited[j] == false) {
                        linkSum += stat[i][j];
                        linkSum += stat[j][i];
                    }
                }
            }
        }
        answer = Math.min(answer, Math.abs(startSum - linkSum));
    }

    public static void dfs(int N, int depth, int start) {

        if (depth == N/2) {
            calcRecord(N);
            return;
        }
        for(int i=start;i<N;i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(N, depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        stat = new int[N][N];
        visited = new boolean[N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(N, 0, 0);

        System.out.println(answer);
        /*
        1,2 3,4
        1,3 2,4
        1,4 2,3
        2,3 1,4
        2,4 1,3
        3,4 1,2
         */

    }

}
