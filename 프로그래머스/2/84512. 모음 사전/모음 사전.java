class Solution {
    
    static char[] mo = {'A', 'E', 'I', 'O', 'U'};
    static int cnt = 0;
    static int answer = -1;
    
    public int solution(String word) {
        dfs(0, word, "");
        return answer;
    }
    
    public void dfs(int depth, String tmp, String word) {
        if (answer > 0) return;
        if (word.equals(tmp)) {
            answer = cnt;
            return;
        }
        if (depth > 5) return;
        
        ++cnt;
        for (int i = 0; i < 5; i++) {
            dfs(depth + 1, tmp, word + mo[i]);
        }
    }
}