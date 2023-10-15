class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(int i=0;i<my_string.length();i++){
            char c = my_string.charAt(i);
            if(Character.isLowerCase(c)) answer += Character.toString(Character.toUpperCase(c));
            else answer += Character.toString(Character.toLowerCase(c));
        }
        return answer;
    }
}