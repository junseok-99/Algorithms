import java.util.*;

class Solution {
    public Set<String> solution(String my_string) {
        Set<String> set = new TreeSet<>();
        int len = my_string.length();
        
        for(int i=my_string.length()-1;i>=0;i--)
            set.add(my_string.substring(i,len));
        
        return set;
    }
}