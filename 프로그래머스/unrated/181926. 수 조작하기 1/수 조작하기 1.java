class Solution {
    public int solution(int n, String control) {
        int answer = n;
        
        for(char c: control.toCharArray())
            if (c=='w') answer++;
            else if(c=='s') answer--;
            else if(c=='d') answer+=10;
            else answer-=10;
        
        return answer;
    }
}