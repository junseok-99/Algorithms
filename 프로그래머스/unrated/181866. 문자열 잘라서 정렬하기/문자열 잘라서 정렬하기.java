import java.util.*;
class Solution {
    public List<String> solution(String myString) {
        List<String> answer = new ArrayList<>();
        String[] tmp = myString.split("x");
        Arrays.sort(tmp);
        
        for(String s: tmp)
            if(!s.equals("")) answer.add(s);
        
        return answer;
    }
}