import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        
        long sum1 = 0L;
        long sum2 = 0L;
        
        for(int i=0;i<queue1.length;i++) {
            sum1 += (long)queue1[i];
            sum2 += (long)queue2[i];
            q1.add((long)queue1[i]);
            q2.add((long)queue2[i]);
        }
        
        long partSum = sum1 + sum2;
        
        if (partSum % 2 == -1) {
            return -1;
        }
        
        partSum /= 2L;
        int limit = queue1.length * 4;
        
        while(answer <= limit) {
            
            if (sum1 < partSum) {
                sum1 += q2.peek();
                sum2 -= q2.peek();
                q1.add(q2.poll());
                ++answer;
            } else if (sum2 < partSum) {
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.add(q1.poll());
                ++answer;
            }
            
            if (sum1 == sum2) {
                return answer;
            }
        }
        
        return -1;
    }
}