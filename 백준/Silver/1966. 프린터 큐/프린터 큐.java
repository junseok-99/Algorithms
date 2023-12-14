import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i=0;i<T;i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Docs> waitDocs = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
            st = new StringTokenizer(br.readLine());
            int cnt = 0;

            for (int j=0;j<N;j++) {
                int per = Integer.parseInt(st.nextToken());
                waitDocs.add(new Docs(per, j));
                pq.add(per);
            }

            while (!waitDocs.isEmpty()) {
                Docs docs = waitDocs.poll();
                if (docs.per != pq.peek()) {
                    waitDocs.add(docs);
                } else if (docs.per == pq.peek()) {
                    ++cnt;
                    pq.poll();
                    if (docs.idx == M) {
                        System.out.println(cnt);
                        break;
                    }
                }
            }
        }
    }
}

class Docs {
    int per;
    int idx;
    public Docs(int per, int idx) {
        this.per = per;
        this.idx = idx;
    }
}
