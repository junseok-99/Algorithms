import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        char[] c = {'R','T','C','F','J','M','A','N'};
        
        for(char a: c)
            m.put(a, 0);
        
        for(int i=0;i<survey.length;i++){
            if(choices[i] > 4) m.put(survey[i].charAt(1), m.get(survey[i].charAt(1))+choices[i]-4);
            else if(choices[i] < 4) m.put(survey[i].charAt(0), m.get(survey[i].charAt(0))+4-choices[i]);
        }
        
        for(int i=0;i<8;i+=2){
            if(m.get(c[i]) >= m.get(c[i+1])) answer += Character.toString(c[i]);
            else if(m.get(c[i]) < m.get(c[i+1])) answer += Character.toString(c[i+1]);
        }
        
        return answer;
    }
}