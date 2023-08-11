import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] s = new String[numbers.length];
        for(int i=0;i<numbers.length;i++)
            s[i] = Integer.toString(numbers[i]);
        
        Arrays.sort(s, (s1,s2) -> {return (s2+s1).compareTo((s1+s2));});
        StringBuilder sb = new StringBuilder();
        
        if(s[0].equals("0")) return "0";
        
        for(int i=0;i<numbers.length;i++)
            sb.append(s[i]);
        
        return sb.toString();
    }
}