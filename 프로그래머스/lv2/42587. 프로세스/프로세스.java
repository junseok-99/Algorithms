import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<priorities.length;i++)
            q.add(i);
        
        while(!q.isEmpty()){
            
            int tmp = q.poll();
            boolean ck = false;
            
            for (Integer num: q) {
                if(priorities[num] > priorities[tmp]){
                    ck = true;
                    break;
                }
            }
            
            if(ck){
                q.add(tmp);
                continue;
            }
            answer++;
            if(tmp == location)
                break;
        }
        return answer;
    }
}