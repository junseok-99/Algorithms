import java.util.*;
import java.awt.Point;
class Solution {
    public int[][] map = new int[102][102];
    public int[] dx = {-1,1,0,0};
    public int[] dy = {0,0,-1,1};
    
    public void BFS(Point start, Point end){
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        map[start.y][start.x] = 0;
        int ty=0,tx=0;
        while(!q.isEmpty()){
            Point p = q.poll();
            
            for(int i=0;i<4;i++){
                ty = p.y + dy[i];
                tx = p.x + dx[i];
                
                if(0 <= tx && tx < 102 && 0 <= ty && ty < 102){
                    if(map[ty][tx] >= 1){
                        q.add(new Point(tx,ty));
                        map[ty][tx] = map[p.y][p.x] + 1;
                        if(ty == end.y && tx == end.x) return;
                    }
                }
            }
            
            map[p.y][p.x] = 0;
        }
    }
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int cnt = 1;
        for(int i=0;i<102;i++)
            Arrays.fill(map[i],-1);
        
        for(int[] crd: rectangle){
            for(int i=crd[1]*2;i<=crd[3]*2;i++){
                for(int j=crd[0]*2;j<=crd[2]*2;j++){
                    if(i>crd[1]*2 && i<crd[3]*2 && j>crd[0]*2 && j<crd[2]*2){
                        map[i][j] = -2;
                        //map[i][j+1] = -2;
                    }
                    else if(map[i][j]==-1){
                        map[i][j] = 1;
                        //map[i+1][j] = 1;
                    }
                }
            }
            cnt++;
        }
        
        BFS(new Point(characterX*2, characterY*2), new Point(itemX*2, itemY*2));
       
        return map[itemY*2][itemX*2]/2;
    }
}