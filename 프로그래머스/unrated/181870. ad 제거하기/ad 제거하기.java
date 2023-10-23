import java.util.*;

class Solution {
    public List<String> solution(String[] strArr) {
        List<String> answer = new ArrayList<String>();
        
        for(String s: strArr)
            if(!s.contains("ad")) answer.add(s);
        
        return answer;
    }
}