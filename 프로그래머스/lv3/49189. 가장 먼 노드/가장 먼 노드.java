import java.util.*;

class Solution {
    int[] arr;
    boolean[] v;
    int maximum = -1;
    
    public void BFS(List<List<Integer>> li){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        v[1] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i=0;i<li.get(node).size();i++){
                int tmp = li.get(node).get(i);
                if(v[tmp] == false){
                    q.add(tmp);
                    arr[tmp] = arr[node] + 1;
                    maximum = Math.max(maximum, arr[tmp]);
                    v[tmp] = true;
                }
            }
        }
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> li = new ArrayList<>();
        arr = new int[n+1];
        v = new boolean[n+1];
        
        for(int i=0;i<n+1;i++)
            li.add(new ArrayList<>());
        
        for(int[] a: edge){
            li.get(a[0]).add(a[1]);
            li.get(a[1]).add(a[0]);
        }
        BFS(li);
        
        Arrays.sort(arr);
        
        for(int i=n;i>=0;i--){
            if(maximum == arr[i]) answer++;
            else break;
        }
        return answer;
    }
}