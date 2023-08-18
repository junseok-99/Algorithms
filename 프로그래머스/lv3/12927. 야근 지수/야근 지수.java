import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for(int i=0;i<works.length;i++) {
            pq.add(works[i]);
        }
        
        while (n > 0) {
            Integer maxHour = pq.poll();
            
            if (maxHour == 0) {
                return 0;
            }
            
            if (pq.isEmpty()) {
                maxHour = maxHour - n < 0 ? 0 : maxHour - n;
                return (long)Math.pow(maxHour, 2);
            } else {
                while (maxHour >= pq.peek() && maxHour > 0 && n > 0) {
                    maxHour--;
                    n--;
                }
            }
            
            pq.add(maxHour);
        }
        
        while (!pq.isEmpty()) {
            int num = pq.poll();
            answer += (long)Math.pow(num, 2);
        }
        
        return answer;
    }
}