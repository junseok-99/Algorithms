import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 5;
        boolean ch;
        LinkedList<String> q = new LinkedList<String>();
        q.add(cities[0]);
        
        if(cacheSize == 0)
            return 5*cities.length;
        
        for(int i=1;i<cities.length;i++){
            Iterator it = q.iterator();
            String tmp;
            ch = false;
            
            while(it.hasNext()){
                tmp = (String)it.next();
                if(cities[i].toUpperCase().equals(tmp.toUpperCase())){
                    answer++;
                    ch = true;
                    break;
                }
            }
            if(!ch)
                answer+=5;
                
            Iterator it2 = q.iterator();
            int cnt = 0;
            boolean lc = false;
            
            while(it2.hasNext()){
                tmp = (String)it2.next();
                if(cities[i].toUpperCase().equals(tmp.toUpperCase())){
                    lc = true;
                    break;
                }
                cnt++;
            }
            if(lc)
                q.remove(cnt);
            else
                if(q.size() == cacheSize)
                    q.poll();
            
            q.add(cities[i]);
        }
        
        return answer;
    }
}