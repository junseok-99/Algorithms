import java.io.*;
import java.util.*;

public class Main {

    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        System.out.println(bfs(n, k));

    }

    public static int bfs(int subin, int brother) {
        Queue<Person> q = new LinkedList<>();
        visited[subin] = true;
        q.add(new Person(subin, 0));
        int shortDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Person p = q.poll();
            visited[p.pos] = true;

            if (p.pos == brother) {
                shortDist = Math.min(shortDist, p.dist);
            }

            if (p.pos * 2 <= 100000 && !visited[p.pos * 2]) {
                q.add(new Person(p.pos * 2, p.dist));
            }
            if (p.pos + 1 <= 100000 && !visited[p.pos + 1]) {
                q.add(new Person(p.pos + 1, p.dist + 1));
            }
            if (p.pos - 1 >= 0 && !visited[p.pos - 1]) {
                q.add(new Person(p.pos - 1, p.dist + 1));
            }

        }
        return shortDist;
    }
}

class Person {
    int pos;
    int dist;

    public Person(int pos, int dist) {
        this.pos = pos;
        this.dist = dist;
    }
}
