class Solution {
    
    public long makePulse(long pulse, int[] sequence) {
        
        long sum = 0;
        long maxNum = -1;
        
        for(int i=0;i<sequence.length;i++) {
            
            sum += (long)sequence[i] * pulse;
            
            if (sum < 0) {
                sum = 0;
            }
            
            maxNum = Math.max(sum, maxNum);
            pulse *= -1;
        }
        
        return maxNum;
    }
    
    public long solution(int[] sequence) {
        long answer = 0;
        
        for(long i=-1L;i<=1L;i+=2L) {
            answer = Math.max(answer, makePulse(i, sequence));
        }
        
        return answer;
    }
}