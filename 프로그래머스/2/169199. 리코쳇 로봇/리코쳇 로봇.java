import java.util.*;

class Point {
    int x;
    int y;
    int d;
    
    Point(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

class Solution {
    
    private int width;
    private int height;
    private int[] dx = {-1,1,0,0};
    private int[] dy = {0,0,-1,1};
    private boolean[][] visited;
    
    public Point makeLastPoint(String[] board, int x, int y, int dxn, int dyn) {
        
        Point point;
        
        while(true) {
            if (y == -1 || y == height || x == -1 || x == width || board[y].charAt(x) == 'D') {
                point = new Point(x - dxn, y - dyn, 0);
                break;
            }
            y += dyn;
            x += dxn;
        }
        
        return point;
    }
    
    public int bfs(String[] board, int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 0));
        visited[y][x] = true;
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            
            if (board[p.y].charAt(p.x) == 'G') {
                return p.d;
            }
            
            for(int i=0;i<4;i++) {
                int tx = p.x + dx[i];
                int ty = p.y + dy[i];
                
                if (tx < 0 || tx >= width || ty < 0 || ty >= height) {
                    continue;
                }
                
                Point lastPoint = makeLastPoint(board, tx, ty, dx[i], dy[i]);
                
                if (!visited[lastPoint.y][lastPoint.x]) {
                    visited[lastPoint.y][lastPoint.x] = true;
                    q.add(new Point(lastPoint.x, lastPoint.y, p.d + 1));
                }
            }
        }
        
        return -1;
    }
    public int solution(String[] board) {
        
        int sx = -1;
        int sy = -1;
        height = board.length;
        width = board[0].length();
        visited = new boolean[height][width];
        
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length();j++) {
                if (board[i].charAt(j) == 'R') {
                    sx = j;
                    sy = i;
                    break;
                }
            }
        }
        
        return bfs(board, sx, sy);
    }
}