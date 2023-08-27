class Solution {
    public int solution(int n) {
        int answer = 0;
        long[] fi = new long[n+1];
        fi[0] = 0; fi[1] = 1;
        
        for(int i=2;i<=n;i++)
            fi[i] = (fi[i-2] + fi[i-1]) % 1234567L;
        
        answer = (int)fi[n];
        return answer;
    }
}