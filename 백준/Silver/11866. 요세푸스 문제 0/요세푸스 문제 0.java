import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer N = Integer.parseInt(st.nextToken());
        Integer K = Integer.parseInt(st.nextToken());
        Queue<Integer> nums = new LinkedList<>();
        List<Integer> li = new ArrayList<Integer>() {
            @Override
            public String toString() {
                StringBuilder s = new StringBuilder();
                s.append("<").append(this.get(0));
                for (int i=1;i<this.size();i++) {
                    s.append(", " + this.get(i));
                }
                s.append(">");
                return s.toString();
            }
        };

        for (int i=1;i<=N;i++) {
            nums.add(i);
        }

        int cnt = 0;
        while (!nums.isEmpty()) {
            Integer n = nums.poll();
            ++cnt;
            if (cnt == K) {
                li.add(n);
                cnt = 0;
            } else {
                nums.add(n);
            }
        }
        System.out.println(li);
    }
}
