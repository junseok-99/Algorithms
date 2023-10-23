import java.util.*;

class Solution {
    public String solution(String rsp) {
        String answer = "";
        Map<Character,String> m = new HashMap<>();
        m.put('2',"0");
        m.put('0',"5");
        m.put('5',"2");
        for(int i=0;i<rsp.length();i++)
            answer += m.get(rsp.charAt(i));
        return answer;
    }
}