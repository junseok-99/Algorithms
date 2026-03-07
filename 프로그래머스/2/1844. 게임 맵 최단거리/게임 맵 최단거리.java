import java.util.*;

class Solution {
    
    int n;
    int m;
    int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        Queue<Ro> q = new ArrayDeque<>();
        q.add(new Ro(0, 0, 1));
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            Ro ro = q.poll();
            
            if (ro.r == n - 1 && ro.c == m - 1) return ro.d;
            
            for (int i = 0; i < 4; i++) {
                int tr = ro.r + d[i][0];
                int tc = ro.c + d[i][1];
                
                if (invalidRange(tr, tc) || visited[tr][tc] || maps[tr][tc] == 0) continue;
                
                q.add(new Ro(tr, tc, ro.d + 1));
                visited[tr][tc] = true;
            }
        }
        
        return -1;
    }
    
    public boolean invalidRange(int r, int c) {
        return r < 0 || r >= n || c < 0 || c >= m;
    }
}

class Ro {
    int r;
    int c;
    int d;
    
    Ro(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}