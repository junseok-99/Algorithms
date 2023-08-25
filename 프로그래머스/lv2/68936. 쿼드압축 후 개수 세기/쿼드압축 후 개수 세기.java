class Solution {
    
    public boolean[][] visited;
    
    public void quadCompression(int[][] arr, int size, int n) {
        int x = 0;
        int y = 0;
        
        while (y < size) {
            int tmp = arr[y][x];
            boolean flag = true;
            
            for(int i=x;i<x+n;i++) {
                for(int j=y;j<y+n;j++) {
                    if (arr[j][i] != tmp) {
                        flag = false;
                        break;
                    }
                }
            }
            
            if (flag) {
                for(int i=x;i<x+n;i++) {
                    for(int j=y;j<y+n;j++) {
                        if (i != x || j != y) {
                            arr[j][i] = 2;
                        }
                    }
                }
            }
            x += n;
            
            if (x >= size) {
                y += n;
                x = 0;
            }
        }
    }
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int len = arr.length;
        int n = len;
        visited = new boolean[len][len];
        
        while (n > 0) {
            quadCompression(arr, len, n);
            n /= 2;
        }
        
        for(int i=0;i<len;i++) {
            for(int j=0;j<len;j++) {
                if (arr[i][j] < 2) {
                    answer[arr[i][j]]++;
                }
            }
        }
        
        return answer;
    }
}