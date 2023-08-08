import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, List<String>> users = new HashMap<>();
        Map<String, Integer> reports = new HashMap<>();
        
        for(String user: id_list)
            users.put(user, new ArrayList<>());
        
        for(String info: report){
            String[] tmp = info.split(" ");
            if(!users.get(tmp[0]).contains(tmp[1])){
                users.get(tmp[0]).add(tmp[1]);
                reports.put(tmp[1], reports.getOrDefault(tmp[1],0) + 1);
            }
        }
        
        for(int i=0;i<id_list.length;i++){
            int cnt = 0;
            for(String r_user: users.get(id_list[i]))
                if(reports.get(r_user) >= k) ++cnt;
            answer[i] = cnt;
        }
        
        return answer;
    }
}