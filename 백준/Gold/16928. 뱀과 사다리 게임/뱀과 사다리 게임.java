import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int[] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new int[101];
        visited = new boolean[101];
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            map[s] = e;
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Deque<Snake> q = new ArrayDeque<>();
        q.add(new Snake(1));
        visited[1] = true;
        int answer = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            ++answer;
            while (size-- > 0) {
                Snake snake = q.poll();

                for (int i = 1; i <= 6; i++) {
                    int tPos = snake.pos + i;

                    if (tPos > 100 || visited[tPos]) continue;
                    else if (tPos == 100) return answer;

                    visited[tPos] = true;
                    if (map[tPos] == 0) q.add(new Snake(tPos));
                    else {
                        visited[map[tPos]] = true;
                        q.add(new Snake(map[tPos]));
                    }
                }
            }
        }
        return -1;
    }
}

class Snake {
    int pos;

    public Snake(int pos) {
        this.pos = pos;
    }
}