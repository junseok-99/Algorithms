class Solution {
    
    int r;
    int c;
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        r = n;
        c = m;
        dp[1][1] = 1;
        
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) continue;
                
                if (!invalidRange(i + 1, j) && dp[i + 1][j] != -1) {
                    dp[i + 1][j] = (dp[i + 1][j] + dp[i][j]) % 1_000_000_007;
                }
                
                if (!invalidRange(i, j + 1) && dp[i][j + 1] != -1) {
                    dp[i][j + 1] = (dp[i][j + 1] + dp[i][j]) % 1_000_000_007;;
                }
            }
        }
        return dp[n][m];
    }
    
    public boolean invalidRange(int i, int j) {
        return i < 1 || i > r || j < 1 || j > c;
    }
}