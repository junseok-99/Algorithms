import java.util.*;

class Solution {
    public int solution(int[] scovilles, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int scoville : scovilles) {
            pq.add(scoville);
        }
        
        int answer = 0;
        while (pq.peek() < K) {
            int one = pq.poll();
            if (pq.isEmpty()) return -1;
            int two = pq.poll();
            pq.add(one + (two * 2));
            ++answer;
        }
        return answer;
    }
}