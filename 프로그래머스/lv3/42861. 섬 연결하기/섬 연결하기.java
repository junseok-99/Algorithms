import java.util.*;

class Solution {
    public int[] nodes;
    
    public int find(int n){
        if(nodes[n] == n)
            return n;
        return nodes[n] = find(nodes[n]);
    }
    
    public void union(int a, int b){
        int node_a = find(a);
        int node_b = find(b);
        if(node_a < node_b)
            nodes[node_b] = node_a;
        else
            nodes[node_a] = node_b;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        nodes = new int[n];
        
        for(int i=0;i<n;i++)
            nodes[i]=i;
        
        Arrays.sort(costs, (o1,o2) -> {
            return o1[2]-o2[2];
        });
        
        for(int[] info: costs){
            if(find(info[0]) != find(info[1])){
                union(info[0],info[1]);
                answer += info[2];
            }
        }
        
        return answer;
    }
}