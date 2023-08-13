import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long left = 0, right = times[times.length-1] * (long)n;
        
        while(left <= right){
            long mid = (left+right) / 2;
            long sum = 0;
            
            for(int i=0;i<times.length;i++)
                sum += (mid / times[i]);
            
            if(sum < n) left = mid+1;
            else if(sum >= n) {
                right = mid-1;
                answer = mid;
            }
        }
        return answer;
    }
}