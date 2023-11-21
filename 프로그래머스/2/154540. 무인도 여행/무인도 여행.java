import java.util.*;
import java.util.stream.*;

class Solution {
    private boolean[][] visited;
    private int[][] map;
    private int width, height;
    private List<Integer> answer = new ArrayList<>();
    private int[] dx = {-1,1,0,0};
    private int[] dy = {0,0,-1,1};
    
    public int dfs(int y, int x, int food) {
        visited[y][x] = true;
        int num = 0;
        for(int i=0;i<4;i++) {
            int tx = dx[i] + x;
            int ty = dy[i] + y;
            
            if(tx >= width || tx < 0 || ty >= height || ty < 0) {
                continue;
            }
            
            if(!visited[ty][tx] && map[ty][tx] > 0) {
                num += dfs(ty,tx, 0 + map[ty][tx]);
            }
        }
        if(num > 0) {
            return num + food;
        }
        return food;
    }
    
    public int[] solution(String[] maps) {
        
        width = maps[0].length();
        height = maps.length;
        visited = new boolean[height][width];
        map = new int[height][width];
        
        for(int i=0;i<height;i++) {
            for(int j=0;j<width;j++) {
                char c = maps[i].charAt(j);
                if(c == 'X') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = Character.getNumericValue(c);
                }
            }
        }
        
        for(int i=0;i<height;i++) {
            for(int j=0;j<width;j++) {
                if(!visited[i][j] && map[i][j] > 0) {
                    answer.add(dfs(i,j,map[i][j]));
                }
            }
        }
        
        if(answer.size() == 0) {
            answer.add(-1);
        }
        
        return answer.stream()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}