import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        Map<String, Integer> m1 = new HashMap<String, Integer>();
        Map<String, Integer> m2 = new HashMap<String, Integer>();
        int inter = 0;
        int uni = 0;
        
        for(int i=0;i<str1.length()-1;i++){
            if(Character.isLetter(str1.charAt(i)) && Character.isLetter(str1.charAt(i+1))){
                String tmp = str1.substring(i,i+2).toUpperCase();
                if(m1.containsKey(tmp)) m1.put(tmp, m1.get(tmp)+1);
                else m1.put(tmp,1);
            }
        }
        
        for(int i=0;i<str2.length()-1;i++){
            if(Character.isLetter(str2.charAt(i)) && Character.isLetter(str2.charAt(i+1))){
                String tmp = str2.substring(i,i+2).toUpperCase();
                if(m2.containsKey(tmp)) m2.put(tmp, m2.get(tmp)+1);
                else m2.put(tmp,1);
            }
        }
        
        for(String s: m1.keySet()){
            if(m2.containsKey(s)){
                inter += Math.min(m1.get(s), m2.get(s));
                uni += Math.max(m1.get(s), m2.get(s));
                m2.remove(s);
            }
            else uni += m1.get(s);
        }
        
        for(String s: m2.keySet())
            uni += m2.get(s);
        
        if(uni == 0 && inter == 0) return 65536;
        answer = (int)(inter/(double)uni*65536);
        return answer;
    }
}