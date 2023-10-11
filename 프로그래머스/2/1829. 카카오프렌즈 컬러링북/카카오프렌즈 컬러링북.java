import java.util.*;

class Pos {
    int x;
    int y;
    int color;
    
    Pos(int y, int x, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}

class Solution {
    
    private boolean[][] visited;
    private int allSpace = 0;
    private int maxSpace = 0;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    
    public void bfs(int m, int n, int y, int x, int[][] picture) {
        Queue<Pos> q = new LinkedList<>();
        int space = 0;
        q.add(new Pos(y, x, picture[y][x]));
        visited[y][x] = true;
        
        while (!q.isEmpty()) {
            Pos p = q.poll();
            ++space;
            
            for(int i=0;i<4;i++) {
                int tx = p.x + dx[i];
                int ty = p.y + dy[i];
                
                if (tx < 0 || tx >= n || ty < 0 || ty >= m) {
                    continue;
                }
                
                if (!visited[ty][tx] && p.color == picture[ty][tx]) {
                    visited[ty][tx] = true;
                    q.add(new Pos(ty, tx, p.color));
                }
            }
        }
        
        maxSpace = Math.max(maxSpace, space);
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        
        visited = new boolean[m][n];
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (!visited[i][j] && picture[i][j] > 0) {
                    bfs(m, n, i, j, picture);
                    ++allSpace;
                }
            }
        }
        
        return new int[]{allSpace, maxSpace};
    }
}