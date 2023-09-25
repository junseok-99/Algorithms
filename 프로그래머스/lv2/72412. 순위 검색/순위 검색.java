import java.util.*;

class Solution {
    
    private Map<String, List<Integer>> table = new HashMap<>();
    
    public void dfs(String[] info, int depth, String s) {
        if (depth == 4) {
            if (!table.containsKey(s)) {
                table.put(s, new ArrayList<>());
            }
            table.get(s).add(Integer.parseInt(info[4]));
            return;
        }
        
        dfs(info, depth + 1, s + "-");
        dfs(info, depth + 1, s + info[depth]);
    }
    
    public int search(String s, int n) {
        int l = 0;
        int r = table.get(s).size();
        int mid = (l + r) / 2;
        List<Integer> li = table.get(s);
        
        while(l < r) {
            mid = (l + r) / 2;
            
            if (li.get(mid) >= n) {
                r = mid;
            } else {
                l = mid + 1; 
            }
        }
        
        return li.size() - r;
    }
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for(int i=0;i<info.length;i++) {
            dfs(info[i].split(" "), 0, "");
        }
        
        for(String s: table.keySet()) {
            Collections.sort(table.get(s));
        }
        
        for(int i=0;i<query.length;i++) {
            String[] tmp = query[i].split(" and | ");
            String s = tmp[0] + tmp[1] + tmp[2] + tmp[3];
            
            if (table.containsKey(s)) {
                answer[i] = search(s, Integer.parseInt(tmp[4]));
            }
        }
        
        return answer;
    }
}