import java.io.*;
import java.util.*;

public class Main{

    static List<List<Integer>> li = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int source = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];

        for(int i=0;i<=n;i++) {
            li.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            li.get(p).add(c);
            li.get(c).add(p);
        }

        System.out.println(bfs(source, dest));

    }

    public static int bfs(int source, int dest) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            if (visited[dest]) {
                return cnt;
            }
            while (size > 0) {
                size--;
                int s = q.poll();
                for(int n: li.get(s)) {
                    if (!visited[n]) {
                        visited[n] = true;
                        q.add(n);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

}