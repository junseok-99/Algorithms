import java.util.*;

class Solution {
    
    public boolean[] v;
    public List<List<Integer>> state = new ArrayList<>();
    
    public int DFS(int n){
        if(v[n]==true) return 0;
        v[n] = true;
        for(int i: state.get(n)){
            if(v[i] == false)
                DFS(i);
        }
        return 1;
    }
    public int solution(int n, int[][] cmp) {
        int answer = 0;
        v = new boolean[n];
        
        for(int i=0;i<n;i++)
            state.add(new ArrayList<>());
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                else if(cmp[i][j] == 1) state.get(i).add(j);
            }
        }
        
        for(int node=0;node<n;node++)
            answer += DFS(node);
        
        return answer;
    }
}