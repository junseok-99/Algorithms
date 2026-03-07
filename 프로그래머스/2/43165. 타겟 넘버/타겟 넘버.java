class Solution {
    
    int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return cnt;
    }
    
    public void dfs(int[] numbers, int target, int sum, int idx) {
        if (idx == numbers.length) {
            if (sum == target) cnt++;
            return;
        }
        
        dfs(numbers, target, sum + numbers[idx], idx + 1);
        dfs(numbers, target, sum - numbers[idx], idx + 1);
    }
}