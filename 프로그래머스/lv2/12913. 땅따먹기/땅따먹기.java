class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][4];
        
        for(int i=0;i<4;i++)
            dp[0][i] = land[0][i];
        
        for(int i=0;i<land.length-1;i++)
            for(int j=0;j<4;j++)
                for(int k=j+1;k<j+4;k++){
                    dp[i+1][k%4] = Math.max(dp[i+1][k%4],land[i+1][k%4]+dp[i][j]);
                    answer = Math.max(answer,dp[i+1][k%4]);
                }

        return answer;
    }
}