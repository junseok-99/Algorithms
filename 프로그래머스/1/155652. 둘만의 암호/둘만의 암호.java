import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        
        StringBuilder answer = new StringBuilder();
        Set<Character> skipTable = new HashSet<>();
        
        for(int i=0;i<skip.length();i++)
            skipTable.add(skip.charAt(i));
        
        for(int i=0;i<s.length();i++){
            int tmp = index;
            int c = s.charAt(i);
            while(tmp > 0){
                c = (1 + c - 'a') % 26 + 'a';
                if(skipTable.contains((char)c)) continue;
                tmp--;
            }
            answer.append(Character.toString(c));
        }
        
        return answer.toString();
    }
}