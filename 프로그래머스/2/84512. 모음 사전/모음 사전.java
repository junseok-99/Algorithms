class Solution {
    
    private int cnt = 0;
    private int answer = -1;
    private String[] arr = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        backTracking("", word, 0);
        return answer;
    }
    
    public void backTracking(String str, String word, int depth) {
        if (depth > 5 || answer > -1) {
            return;
        }
        
        if (str.equals(word)) {
            answer = cnt;
            return;
        }
        
        ++cnt;
        
        for (int i = 0; i < 5; i++) {
            backTracking(str + arr[i], word, depth + 1);
        }
    }
}