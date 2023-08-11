import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> hash = new HashSet<String>();
        int size = phone_book.length;
        Set<Integer> len = new HashSet<Integer>();
        
        for(int i=0;i<size;i++){
            hash.add(phone_book[i]);
            len.add(phone_book[i].length());
        }
        
        for(int i=0;i<size;i++)
            for(int j: len)
                if(j >= phone_book[i].length()) continue;
                else if(hash.contains(phone_book[i].substring(0,j))) return false;
            
        
        return answer;
    }
}