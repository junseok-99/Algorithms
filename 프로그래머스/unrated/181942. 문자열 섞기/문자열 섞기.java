class Solution {
    public String solution(String str1, String str2) {
        StringBuilder answer = new StringBuilder();
        
        for(int i=0;i<str1.length();i++)
            answer.append(Character.toString(str1.charAt(i))+Character.toString(str2.charAt(i)));
        return answer.toString();
    }
}