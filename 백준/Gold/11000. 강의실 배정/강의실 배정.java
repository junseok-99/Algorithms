import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    
    static class Room implements Comparable<Room>{
        int s;
        int e;
        Room(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Room other) {
            if(s == other.s) {
                return e - other.e;
            }
            return s - other.s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Room[] rooms = new Room[N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            rooms[i] = new Room(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(rooms);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(rooms[0].e);

        for(int i=1;i<N;i++) {
            if(pq.peek() <= rooms[i].s) {
                pq.poll();
            }
            pq.add(rooms[i].e);
        }


        System.out.println(pq.size());
        /*
        1 2 3
          2 3 4
            3 4 5
         */
    }

}
