class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        int len = sticker.length;
        
        if (len == 1) {
            return sticker[0];
        }
        
        int[] dp = new int[len];
        
        dp[0] = sticker[0];
        dp[1] = sticker[0];
        
        for(int i=2;i<len-1;i++) {
            dp[i] = Math.max(dp[i-2] + sticker[i], dp[i-1]);
        }
        answer = dp[len - 2];
        
        dp[0] = 0;
        dp[1] = sticker[1];
        for(int i=2;i<len;i++) {
            dp[i] = Math.max(dp[i-2] + sticker[i], dp[i-1]);
        }

        return Math.max(answer, dp[len-1]);
    }
}