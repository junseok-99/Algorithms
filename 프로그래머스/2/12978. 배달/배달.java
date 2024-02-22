import java.util.*;

class Solution {
    private int[][] map;
    private boolean[] v;
    private int[] d;
    private int inf = 100000000;
    
    public int smallIdx(int N){
        int min = inf;
        int idx = 0;
        for(int i=1;i<N+1;i++){
            if(d[i] < min && !v[i]){
                min = d[i];
                idx = i;
            }
        }
        return idx;
    }
    
    public void dijkstra(int N){
        for(int i=1;i<N+1;i++)
            d[i] = map[1][i];
        
        v[1] = true;
        for(int i=1;i<N-2;i++){
            int cur = smallIdx(N);
            v[cur] = true;
            
            for(int j=1;j<N+1;j++){
                if(!v[j]){
                    if(d[cur]+map[cur][j] < d[j])
                        d[j] = d[cur] + map[cur][j];
                }
            }
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        d = new int[N+1];
        v = new boolean[N+1];
        map = new int[N+1][N+1];
        
        for(int i=0;i<N+1;i++){
            Arrays.fill(map[i], inf);
            map[i][i] = 0;
        }
        
        for(int[] n: road){
            map[n[0]][n[1]] = Math.min(map[n[0]][n[1]],n[2]);
            map[n[1]][n[0]] = Math.min(map[n[1]][n[0]],n[2]);
        }
        
        dijkstra(N);
        
        for(int i=1;i<N+1;i++)
            if(d[i] <= K) answer++;
        
        return answer;
    }
}