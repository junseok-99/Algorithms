import java.util.*;

class Point {
    int x;
    int y;
    int dis;
    Point(int y, int x, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

class Solution {
    
    private char[][] map;
    private boolean isLever;
    private boolean visited[][];
    private int width, height;
    private int[] dx = {-1,1,0,0};
    private int[] dy = {0,0,-1,1};
    private int answer = -1;
    
    public void bfs(Point p) {
        Queue<Point> q = new LinkedList<>();
        q.add(p);
        visited[p.y][p.x] = true;
        
        while(!q.isEmpty()) {
            
            Point tp = q.poll();
            
            if(map[tp.y][tp.x] == 'E' && isLever) {
                answer = tp.dis;
                return;
            }
            
            for(int i=0;i<4;i++) {
                int tx = tp.x + dx[i];
                int ty = tp.y + dy[i];
                if(tx >= width || tx < 0 || ty >= height || ty < 0) {
                    continue;
                }
                if(!visited[ty][tx]) {
                    if(map[ty][tx] != 'X') {
                        if(!isLever && map[ty][tx] == 'L') {
                            isLever = true;
                            visited = new boolean[height][width];
                            q.clear();
                            visited[ty][tx] = true;
                            q.add(new Point(ty,tx, tp.dis + 1));
                            break;
                        }
                        visited[ty][tx] = true;
                        q.add(new Point(ty,tx, tp.dis + 1));
                    } 
                }
            }
        }
    }
    
    public int solution(String[] maps) {
        
        width = maps[0].length();
        height = maps.length;
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[height][width];
        isLever = false;
        Point start = new Point(0,0,0);
        
        for(int i=0;i<height;i++) {
            for(int j=0;j<width;j++) {
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S') {
                    start = new Point(i,j,0);
                }
            }
        }
        
        bfs(start);
        
        return answer;
    }
    
}