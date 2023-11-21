import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            int sum1 = o1[1] - o1[0];
            int sum2 = o2[1] - o2[0];
            
            if(sum1 == sum2) {
                return o1[0] - o2[0];
            }
            return sum1 - sum2;
        });
        
        int size = sequence.length;
        int left = 0;
        int right = -1;
        int sum = 0;
        
        while(true) {
            
            if (right == size-1) {
                
                if (sum == k) {
                    pq.add(new int[]{left, right});
                } else if (sum < k) {
                    break;
                }
                
                if (left == right) {
                    break;
                }
                
                sum -= sequence[left++];
            } else if (right < size){
            
                if (sum == k) {
                    pq.add(new int[]{left, right});
                    sum += sequence[++right];
                } else if (sum > k) {
                    sum -= sequence[left++];
                } else if (sum < k) {
                    sum += sequence[++right];
                }
            }
        }
        
        
        return pq.peek();
    }
}