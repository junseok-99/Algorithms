import java.util.Arrays;

class Solution {
    
    private final int INF = 1000001;
    
    public int solution(int x, int y, int n) {
        int[] dp = new int[y+1];
        
        Arrays.fill(dp, INF);
        dp[x] = 0;
        
        for(int i=x;i<y;i++) {
            if (i + n <= y) {
                dp[i+n] = Math.min(dp[i]+1, dp[i+n]);
            }
            if (i * 2 <= y) {
                dp[i*2] = Math.min(dp[i]+1, dp[i*2]);
            }
            if (i * 3 <= y) {
                dp[i*3] = Math.min(dp[i]+1, dp[i*3]);
            }
        }
        
        return dp[y] == INF ? -1 : dp[y];
    }
}