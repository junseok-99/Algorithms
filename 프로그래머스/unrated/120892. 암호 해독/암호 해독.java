class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        for(int i=code;i<=cipher.length();i+=code)
            answer += cipher.substring(i-1,i);
        
        return answer;
    }
}