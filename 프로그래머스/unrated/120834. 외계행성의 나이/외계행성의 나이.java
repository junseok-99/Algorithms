class Solution {
    public String solution(int age) {
        String answer = "";
        char[] sp = new char[10];
        
        for(int i=0;i<10;i++)
            sp[i] = (char)(97+i);
        
        for(char c: Integer.toString(age).toCharArray())
            answer += Character.toString(sp[Character.getNumericValue(c)]);
        
        return answer;
    }
}