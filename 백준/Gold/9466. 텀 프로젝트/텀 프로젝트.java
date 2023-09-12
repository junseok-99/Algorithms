import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int cnt;
    private static int[] students;
    private static boolean[] visited;
    private static boolean[] finished;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++) {
            n = Integer.parseInt(br.readLine());
            students = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=n;i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            cnt = 0;

            for(int i=1;i<=n;i++) {
                dfs(i);
            }

            bw.write(n - cnt + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    public static void dfs(int num) {

        visited[num] = true;
        int next = students[num];

        if (!visited[next]) {
            dfs(next);
        }

        if (!finished[next]) {
            ++cnt;

            while (next != num) {
                ++cnt;
                next = students[next];
            }
        }

        finished[num] = true;
    }

}
