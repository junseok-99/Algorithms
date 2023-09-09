import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr) {
        
        List<Integer> stk = new ArrayList<>();
        int lastIdx = 0;
        
        for(int i=0;i<arr.length;i++) {
            if (stk.isEmpty() || stk.get(lastIdx - 1) < arr[i]) {
                stk.add(arr[i]);
                lastIdx++;
            } else {
                stk.remove(--lastIdx);
                i--;
            }
        }
        
        return stk;
    }
}