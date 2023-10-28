import java.util.*;

class Solution {
    public List<String> solution(String myStr) {
        String[] answer = myStr.split("[a-c]");
        List<String> li = new ArrayList<String>();
        
        if(answer.length == 0) return new ArrayList<>(Arrays.asList("EMPTY"));
        for(String s: answer)
            if(!s.equals("")) li.add(s);
        
        
        return li;
    }
}