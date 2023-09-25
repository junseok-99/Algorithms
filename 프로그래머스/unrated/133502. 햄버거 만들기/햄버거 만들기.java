import java.util.*;

class Solution {
    public int solution(int[] ig) {
        int answer = 0;
        Stack<Integer> s = new Stack<Integer>();
        
        for(int i: ig){
            s.push(i);
            if(s.size() > 3){
                if(s.get(s.size()-1) == 1 && s.get(s.size()-2) == 3 && s.get(s.size()-3) == 2 &&s.get(s.size()-4) == 1){
                    s.pop();s.pop();s.pop();s.pop();
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
}