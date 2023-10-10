import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr) {
        
        List<Integer> answer = new ArrayList<>();
        
        for(int n: arr)
            for(int i=0;i<n;i++)
                answer.add(n);
        return answer;
    }
}