import java.awt.Point;
import java.util.*;

class Solution {
    
    public int check(char[][] map,int m,int n){
        Set<Point> set = new HashSet<>();
        
        for(int i=0;i<m-1;i++){
            for(int j=0;j<n-1;j++){
                if(map[i][j] != '-' && map[i][j] == map[i+1][j] && map[i][j] == map[i][j+1] && map[i][j] == map[i+1][j+1]){
                    set.add(new Point(j,i));
                    set.add(new Point(j,i+1));
                    set.add(new Point(j+1,i));
                    set.add(new Point(j+1,i+1));
                }
            }
        }
       
        for(Point p: set)
            map[p.y][p.x] = '-';
        
        return set.size();
    }
    
    public void move(char[][] map, int m, int n){
        
        for(int i=1;i<m;i++)
            for(int j=0;j<n;j++)
                if(map[i][j] == '-'){
                    for(int k=i;k>0;k--){
                        map[k][j] = map[k-1][j];
                        map[k-1][j] = '-';  
                    }
                } 
    }
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                map[i][j] = board[i].charAt(j);
        
        while(true){
            int cnt = check(map,m,n);
            if(cnt == 0) break;
            answer += cnt;
            move(map,m,n);
        }
        
        return answer;
    }
}