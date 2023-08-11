import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> m = new HashMap<>();
        
        for(String[] s: clothes){
            if(!m.containsKey(s[1])) m.put(s[1],2);
            else m.put(s[1], m.get(s[1])+1);
        }
        
        Collection<Integer> clo = m.values();
        for(int n: clo) answer *= n;
        
        return answer-1;
    }
}