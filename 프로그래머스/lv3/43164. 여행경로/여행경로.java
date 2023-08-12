import java.util.*;

class Solution {
    private List<String> ret = new ArrayList<>();
    private int max_length;
    private boolean[] visited;
    private String[][] tmp;
    
    public void DFS(String s, String route, int cnt){
        if (cnt==max_length){
            ret.add(route);
            return;
        }
        for(int i=0;i<max_length;i++){
            if(!visited[i] && tmp[i][0].equals(s)){
                visited[i] = true;
                DFS(tmp[i][1],route+" "+tmp[i][1],cnt+1);
                visited[i] = false;
            }
        }
    }
    public String[] solution(String[][] tickets) {
        
        max_length = tickets.length;
        visited = new boolean[max_length];
        tmp = tickets;
        
        DFS("ICN","ICN",0);
        Collections.sort(ret);
        
        return ret.get(0).split(" ");
    }
}