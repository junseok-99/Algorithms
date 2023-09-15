import java.util.Arrays;
class Solution {
    
    private int[][] map;
    private int row;
    private int col;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        
        int[] answer = new int[queries.length];
        map = new int[rows+1][columns+1];
        row = rows;
        col = columns;
        
        init(rows, columns);
        
        for(int i=0;i<queries.length;i++) {
            answer[i] = spin(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }
        
        //System.out.println(Arrays.deepToString(map));
        
        return answer;
    }
    
    public void init(int rows, int columns) {
        for(int i=1;i<=rows;i++) {
            for(int j=1;j<=columns;j++) {
                map[i][j] = ((i-1) * columns + j);
            }
        }
    }
    
    public int spin(int x1, int y1, int x2, int y2) {
        
        int[][] copyMap = map.clone();
        int min = 10001;
        
        for(int i=0;i<=row;i++) {
            copyMap[i] = map[i].clone();    
        }
        
        for(int i=1;i<=y2-y1;i++) {
            copyMap[x1][y1+i] = map[x1][y1+i-1];
            copyMap[x2][y2-i] = map[x2][y2-i+1];
            min = Math.min(min, Math.min(copyMap[x1][y1+i], copyMap[x2][y2-i]));
        }
        
        for(int i=1;i<=x2-x1;i++) {
            copyMap[x1+i][y2] = map[x1+i-1][y2];
            copyMap[x2-i][y1] = map[x2-i+1][y1];
            min = Math.min(min, Math.min(copyMap[x1+i][y2], copyMap[x2-i][y1]));
        }
        
        map = copyMap;        
        return min;
    }
    
}