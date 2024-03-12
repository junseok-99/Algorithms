import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        Deque<Integer> deq = new ArrayDeque<>();

        while (N-- > 0) {
            int buildingCnt = Integer.parseInt(br.readLine());

            while (!deq.isEmpty() && deq.peekFirst() <= buildingCnt) {
                deq.pop();
            }
            answer += deq.size();
            deq.push(buildingCnt);
        }
        System.out.println(answer);
    }
}