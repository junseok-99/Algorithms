import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Set<Integer> chulsoo = new HashSet<>();
        Set<Integer> brother = new HashSet<>();
        
        int size = topping.length;
        int[] cnt = new int[size+1];
        
        chulsoo.add(topping[0]);
        
        for(int i=1;i<size;i++) {
            brother.add(topping[i]);
            cnt[topping[i]]++;
        }
        
        for(int i=1;i<size;i++) {
            if(chulsoo.size() == brother.size()) {
                ++answer;
            }
            
            chulsoo.add(topping[i]);
            
            if (cnt[topping[i]] >= 1) {
                cnt[topping[i]]--;
            }
            if(cnt[topping[i]] == 0) {
                brother.remove(topping[i]);
            }
            
        }
        return answer;
    }
}