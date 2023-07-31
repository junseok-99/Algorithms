import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long allSum=0L;
        long sum=0L;

        PriorityQueue<Long> q = new PriorityQueue<>();
        for(int i=0;i<n;i++) {
            q.add(Long.parseLong(br.readLine()));
        }

        while(q.size() > 1) {
            sum = q.poll() + q.poll();
            allSum += sum;
            q.add(sum);
        }

        bw.write(allSum+"");
        bw.flush();
        bw.close();

    }
}
