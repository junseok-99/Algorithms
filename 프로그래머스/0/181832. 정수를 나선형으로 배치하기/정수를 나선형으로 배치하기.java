class Solution {
    
    int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int dIdx = 0;
    
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        dfs(answer, 0, 0, n, 1);
        return answer;
    }
    
    public void dfs(int[][] arr, int r, int c, int n, int sum) {
        if (invalidRange(r, c, n) || arr[r][c] != 0) return;

        arr[r][c] = sum;
        
        int tr = r + d[dIdx][0];
        int tc = c + d[dIdx][1];
        if (invalidRange(tr, tc, n) || arr[tr][tc] > 0) dIdx = (dIdx + 1) % d.length;
        dfs(arr, r + d[dIdx][0], c + d[dIdx][1], n, sum + 1);
    }
    
    public boolean invalidRange(int r, int c, int n) {
        return r < 0 || r >= n || c < 0 || c >= n;
    }
}