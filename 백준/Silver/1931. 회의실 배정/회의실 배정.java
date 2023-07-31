import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int answer = 1;

        List<int[]> rooms = new ArrayList<>();

        for(int i=0;i<n;i++) {
            String[] room = br.readLine().split(" ");
            rooms.add(new int[]{Integer.parseInt(room[0]), Integer.parseInt(room[1])});
        }

        Collections.sort(rooms, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int lastEndTime = rooms.get(0)[1];
        for(int i=1;i<n;i++) {
            if(rooms.get(i)[0] < lastEndTime) {
                continue;
            } else if(rooms.get(i)[0] >= lastEndTime){
                answer++;
                lastEndTime = rooms.get(i)[1];
            }
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();

        /*
        1 2 3 4
            3 4 5
      0 1 2 3 4 5 6
                5 6 7
            3 4 5 6 7 8
                5 6 7 8 9
                  6 7 8 9 10
                      8 9 10 11
                      8 9 10 11 12
          2 3 4 5 6 7 8 9 10 11 12 13
                                12 13 14
        */
    }
}
