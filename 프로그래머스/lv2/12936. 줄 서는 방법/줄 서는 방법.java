import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> li = new ArrayList<>();
        long facto = 1L;
        int idx = 0;
        k--;
        
        for(int i=1;i<=n;i++) {
            facto *= (long)i;
            li.add(i);
        }
        
        while (idx < n) {
            facto /= (n-idx);
            answer[idx++] = li.remove((int)(k / facto));
            k %= facto;
        }
        return answer;
    }
}