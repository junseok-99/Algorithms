import java.util.*;

class Point {
    int x;
    int y;
    int d;
    
    Point(int y, int x, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

class Solution {
    
    private int[] dx = {-1, 1, 0,0};
    private int[] dy = {0, 0, -1, 1};
    
    public boolean bfs(String[] places, int y, int x) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        q.add(new Point(y, x, 0));
        visited[y][x] = true;
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            
            if (p.d > 2) {
                continue;
            }
            if (p.d != 0 && places[p.y].charAt(p.x) == 'P') {
                return false;
            }
            
            for(int i=0;i<4;i++) {
                int tx = p.x + dx[i];
                int ty = p.y + dy[i];
                
                if (tx < 0 || tx > 4 || ty < 0 || ty > 4) {
                    continue;
                }
                if (visited[ty][tx]) {
                    continue;
                }
                if (places[ty].charAt(tx) == 'X') {
                    continue;
                }
                
                q.add(new Point(ty, tx, p.d + 1));
                visited[ty][tx] = true;
            }
        }
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i=0;i<5;i++) {
            boolean ret = true;
            for(int j=0;j<5;j++) {
                for(int k=0;k<5;k++) {
                    if (places[i][j].charAt(k) == 'P') {
                        ret = bfs(places[i], j, k);
                    }
                    if (!ret) {
                        break;
                    }
                }
                if (!ret) {
                        break;
                    }
            }
            answer[i] = ret ? 1 : 0;
        }
        
        return answer;
    }
}