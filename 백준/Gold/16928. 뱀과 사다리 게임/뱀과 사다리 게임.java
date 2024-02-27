import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[101];
        visited = new boolean[101];

        for (int i = 1; i <= 100; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            parents[a] = b;
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Deque<User> q = new ArrayDeque<>();
        q.add(new User(1, 0));
        visited[1] = true;

        while (!q.isEmpty()) {
            User user = q.poll();

            if (user.curNum == 100) {
                return user.dist;
            }

            for (int i = 1; i <= 6; i++) {
                int willMoveNum = user.curNum + i;
                if (willMoveNum > 100) continue;
                
                willMoveNum = parents[willMoveNum];
                if (willMoveNum > 100 || visited[willMoveNum]) continue;
                
                visited[willMoveNum] = true;
                q.add(new User(willMoveNum, user.dist + 1));
            }
        }
        return -1;
    }
}

class User {
    int curNum;
    int dist;

    public User(int curNum, int dist) {
        this.curNum = curNum;
        this.dist = dist;
    }
}