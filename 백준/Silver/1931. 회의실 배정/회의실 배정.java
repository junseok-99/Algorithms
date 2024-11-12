import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Room> pq = new PriorityQueue();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            pq.add(new Room(s, e));
        }

        int endTime = pq.poll().e;
        int answer = 1;

        while (!pq.isEmpty()) {
            Room room = pq.poll();

            if (room.s >= endTime) {
                ++answer;
                endTime = room.e;
            }
        }
        System.out.println(answer);
    }

}

class Room implements Comparable<Room>{
    int s;
    int e;

    public Room(int s, int e) {
        this.s = s;
        this.e = e;
    }

    public int compareTo(Room tr) {
        if (Integer.compare(this.e, tr.e) == 0) {
            return Integer.compare(this.s, tr.s);
        }
        return Integer.compare(this.e, tr.e);
    }
}