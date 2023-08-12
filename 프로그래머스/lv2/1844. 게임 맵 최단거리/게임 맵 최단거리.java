import java.util.*;
import java.awt.Point;

class Solution {
    public int[] dx = {-1,0,1,0};
    public int[] dy = {0,1,0,-1};
    public int width;
    public int height;
    
    public void bfs(int[][] m,int x,int y){
        Queue<Point> q = new LinkedList<Point>();
        boolean[][] v = new boolean[height][width];
        q.add(new Point(x,y));
        v[y][x] = true;
        while(!q.isEmpty()){
            Point tp = q.poll();
            
            for(int i=0;i<4;i++){
                int tx = tp.x+dx[i];
                int ty = tp.y+dy[i];
               
                if(tx < 0 || tx == width || ty < 0 || ty == height) continue;
                if(v[ty][tx] == false && m[ty][tx] == 1){
                    m[ty][tx] += m[tp.y][tp.x];
                    if(tx == width -1 && ty == height-1) break;
                    q.add(new Point(tx,ty));
                    v[tp.y][tp.x] = true;
                }
            }
        }
        
    }
    public int solution(int[][] maps) {
        width = maps[0].length;
        height = maps.length;
        bfs(maps,0,0);
        
        return maps[height-1][width-1] == 1 ? -1 : maps[height-1][width-1];
    }
}