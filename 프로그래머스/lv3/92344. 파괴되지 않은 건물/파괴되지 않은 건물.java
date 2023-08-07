import java.util.Arrays;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] preeSum = new int[n+1][m+1];
        
        for(int i=0;i<skill.length;i++) {
            int degree = skill[i][5] * (skill[i][0] == 1 ? -1 : 1);
            
            int y1 = skill[i][1];
            int x1 = skill[i][2];
            int y2 = skill[i][3];
            int x2 = skill[i][4];
            
            preeSum[y1][x1] += degree;
            preeSum[y1][x2+1] += degree * -1;
            preeSum[y2+1][x1] += degree * -1;
            preeSum[y2+1][x2+1] += degree;
            
        }
        
         for(int j=1;j<=n;j++) {
                for(int k=0;k<=m;k++) {
                    preeSum[j][k] += preeSum[j-1][k];
                }
            }
            
        for(int j=1;j<=m;j++) {
            for(int k=0;k<=n;k++) {
                preeSum[k][j] += preeSum[k][j-1];
            }
        }
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if (board[i][j] + preeSum[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}