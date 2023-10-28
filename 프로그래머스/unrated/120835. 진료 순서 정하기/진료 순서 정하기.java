import java.util.*;
class Solution {
    public int[] solution(int[] emergency) {
        int len = emergency.length;
        int[] answer;
        answer = Arrays.copyOf(emergency,len);
        Arrays.sort(emergency);
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<len;i++)
            m.put(emergency[i],Math.abs(i-len));
        for(int i=0;i<len;i++)
            answer[i] = m.get(answer[i]);
            
        return answer;
    }
}