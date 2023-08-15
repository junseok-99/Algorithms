import java.util.*;

class Solution {
    
    private int[] dx = {0,-1,1,0};
    private int[] dy = {1,0,0,-1};
    private String[] dirs = {"d", "l", "r", "u"};
    private StringBuilder answer = new StringBuilder();
    private String realAnswer;
    private boolean flag = false;
    private boolean[][][] visited;
    
    public int getDis(int sx, int sy, int ex, int ey) {
        return Math.abs(sx - ex) + Math.abs(sy - ey);
    }
    
    public boolean checkArri(int sx, int sy, int ex, int ey, int k) {
        int d = getDis(sx, sy, ex, ey);
        if (d > k || (k-d) % 2 == 1) {
            return true;
        }
        return false;
    }
    
    public void dfs(int n, int m, int sy, int sx, int ey, int ex, int k, int tk) {
        
        if (flag || tk > k) {
            return;
        }
        
        if (k == tk && getDis(sx, sy, ex, ey) == 0) {
            flag = true;
            realAnswer = answer.toString();
            return;
        }
        
        for(int i=0;i<4;i++) {
            int tx = sx + dx[i];
            int ty = sy + dy[i];
            
            if (tx < 0 || tx >= m || ty < 0 || ty >= n) {
                continue;
            }
            if (!visited[ty][tx][tk]) {
                visited[ty][tx][tk] = true;
                answer.append(dirs[i]);
                dfs(n, m, ty, tx, ey, ex, k, tk + 1);
                answer.deleteCharAt(tk);
            }
        }
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        visited = new boolean[n][m][k+1];
        if (checkArri(y - 1, x - 1, c - 1, r - 1, k)) {
            return "impossible";
        }
        dfs(n, m, x - 1, y - 1, r - 1, c - 1, k, 0);
        
        return realAnswer;
    }
}