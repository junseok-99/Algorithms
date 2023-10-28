class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int len = pat.length();
        
        for(int i=0;i<=myString.length()-len;i++)
            if(myString.substring(i,i+len).equals(pat)) answer++;
        
        return answer;
    }
}