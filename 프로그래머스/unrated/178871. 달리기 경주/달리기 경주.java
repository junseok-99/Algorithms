import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> pnames = new HashMap<>();
        Map<Integer, String> pindexs = new HashMap<>();
        String[] answer = new String[players.length];
        
        for(int i=0;i<players.length;i++){
            pnames.put(players[i], i);
            pindexs.put(i, players[i]);
        }
        
        for(int i=0;i<callings.length;i++){
            int cur = pnames.get(callings[i]);
            String tmp = pindexs.get(cur-1);
            pnames.put(callings[i], cur-1);
            pnames.put(tmp, cur);
            pindexs.put(cur, tmp);
            pindexs.put(cur-1, callings[i]);
        }
        
        for(int i=0;i<players.length;i++)
            answer[i] = pindexs.get(i);
        
        return answer;
    }
}