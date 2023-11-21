import java.util.Queue;
import java.util.LinkedList;

class Solution {
    private final String yes = "Yes";
    private final String no = "No";
    
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        
        for(int i=0;i<cards1.length;i++) {
            q1.add(cards1[i]);
        }
        
        for(int i=0;i<cards2.length;i++) {
            q2.add(cards2[i]);
        }
        
        for(String s: goal) {
            if(!q1.isEmpty() && q1.peek().equals(s)) {
                q1.poll();
                continue;
            } else if(!q2.isEmpty() && q2.peek().equals(s)) {
                q2.poll();
                continue;
            } 
            return no;
        }
        
        return yes;
    }
}