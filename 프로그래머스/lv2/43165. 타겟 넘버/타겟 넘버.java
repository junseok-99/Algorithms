class Solution {
    static int answer = 0;
    static int[] tmp;
    static int t;
    
    public void dfs(int d, int n){
        if(d==tmp.length){
            if(n==t) answer++;
            return;
        }
        dfs(d+1, n+tmp[d]);
        dfs(d+1, n-tmp[d]);
        
    }
    public int solution(int[] numbers, int target) {
        tmp = numbers;
        t = target;
        dfs(0,0);
        return answer;
    }
}