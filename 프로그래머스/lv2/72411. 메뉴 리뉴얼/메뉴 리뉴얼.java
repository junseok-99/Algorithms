import java.util.*;

class Solution {
    
    private Map<String, Integer> map = new HashMap<>();
    private boolean[] visited;
    private int[] cnts = new int[11];
    
    public void dfs(String order, int depth, String tmp) {
        if (depth == order.length()) {
            return;
        }
        for(int i=depth;i<order.length();i++) {
            if (!visited[i]) {
                visited[i] = true;
                String s = tmp + order.substring(i, i+1);
                map.put(s, map.getOrDefault(s, 0) + 1);
                cnts[s.length()] = Math.max(cnts[s.length()], map.get(s));
                dfs(order, i + 1, s);
                visited[i] = false;
            }
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        
        List<String> answer = new ArrayList<>();
        
        for(int i=0;i<orders.length;i++) {
            visited = new boolean[orders[i].length()];
            char[] tmp = orders[i].toCharArray();
            Arrays.sort(tmp);
            dfs(new String(tmp), 0, "");
        }
        
        for(String key: map.keySet()) {
            for(int n: course) {
                if (key.length() == n && map.get(key) == cnts[key.length()] && map.get(key) > 1) {
                    answer.add(key);
                }
            }
        }
        
        return answer.stream()
                    .sorted()
                    .toArray(String[]::new);
    }
}