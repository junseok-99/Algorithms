import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(int n: scoville) {
            pq.add((long)n);
        }
        
        while(pq.peek() < K) {
            long n1 = pq.poll();
            if(pq.isEmpty()) {
                pq.add(n1);
                break;
            }
            long n2 = pq.poll() * 2L;
            
            pq.add(n1+n2);
            
            ++answer;
        }
        
        return pq.peek() < K ? -1 : answer;
    }
}