import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int prev,cnt=0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(tangerine);
        prev = tangerine[0];
        
        for(int i=0;i<tangerine.length;i++){
            if(prev == tangerine[i])
                cnt++;
            else{
                prev = tangerine[i];
                pq.add(cnt);
                cnt = 1;
            }
            if(i == tangerine.length-1)
                pq.add(cnt);
        }
        while(k>0){
            answer++;
            k -= pq.poll();
        }
        return answer;
    }
}