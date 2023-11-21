class Solution {
    public int solution(int n, int m, int[] section) {
        int answer =1;
        int cnt = 1, left = section[0], right = m + section[0], len = section.length;
        while(cnt != len){
            if(left <= section[cnt] && section[cnt] < right) {
                cnt++;
            }
            else{
                answer++;
                left = section[cnt];
                right = section[cnt] + m > n ? n+1 : section[cnt] + m;
            }
        }
        
        return answer;
    }
}