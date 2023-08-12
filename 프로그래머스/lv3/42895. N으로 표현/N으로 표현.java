import java.util.*;

class Solution {
    
    public void addNum(List<Set<Integer>> list, int N, int step) {
        
        for(int i=1;i<step;i++) {
            for(Integer n1: list.get(i)) {
                for(Integer n2: list.get(step-i)) {
                    list.get(step).add(n1+n2);
                    list.get(step).add(n1-n2);
                    list.get(step).add(n1*n2);
                    list.get(step).add(n2+n1);
                    
                    if (n2 != 0) {
                        list.get(step).add(n1/n2);
                    }
                    if (n1 != 0) {
                        list.get(step).add(n2/n1);
                    }
                    
                    
                }
            }
        }
        
        list.get(step).add(Integer.parseInt(Integer.toString(N).repeat(step)));
    }
    
    public int solution(int N, int number) {
        
        List<Set<Integer>> map = new ArrayList<>();
        
        for(int i=0;i<=8;i++) {
            map.add(new HashSet<Integer>());
        }
        
        for(int i=1;i<=8;i++) {
            addNum(map, N, i);
            if(map.get(i).contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}
/**
*   1  2   3   4 5
    5 5+5 5+5+5
      5-5 5
      5/5
      5*5
      55
**/