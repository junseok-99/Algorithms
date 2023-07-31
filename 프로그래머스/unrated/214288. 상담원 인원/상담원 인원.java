import java.util.*;

class Solution {
    
    List<String> li = new ArrayList<>();
    int answer = Integer.MAX_VALUE;
    
    public void dfs(int[][] reqs, int[] mentos, int n,int k, int depth, int sum) {
        
        if (depth == k) {
            if (n == sum) {
                answer = Math.min(answer, checkTime(reqs, mentos, n, k));
            }
            return;        
        }
        
        for(int i=1;i<=n-sum;i++) {
            mentos[depth+1] = i;
            dfs(reqs, mentos, n, k, depth + 1, sum + i);
        }
    }
    
    public int checkTime(int[][] reqs, int[] mentos, int n, int k) {
        
        List<PriorityQueue<Integer>> li = new ArrayList<>();
        int waitTime = 0;
        
        for(int i=0;i<=k;i++) {
            li.add(new PriorityQueue<>());
        }
        
        for(int[] req: reqs) {
            int num = req[2];
            int startTime = req[0];
            int requireTime = req[1];
            int endTime = req[0] + req[1];
            PriorityQueue<Integer> pq = li.get(num);
            
            if (!pq.isEmpty()) {
                if (pq.size() == mentos[num]) {
                    int firstEndTime = pq.poll();
                    
                    if (firstEndTime > startTime) {
                        waitTime += firstEndTime - startTime;
                        pq.add(firstEndTime + requireTime);
                        continue;
                    }
                } 
            }
            pq.add(endTime);
            
        }
        return waitTime;
    }
    
    public int solution(int k, int n, int[][] reqs) {
        
        int[] mentos = new int[k+1];
        
        dfs(reqs, mentos, n, k, 0, 0);
        
        return answer;
    }
    
}