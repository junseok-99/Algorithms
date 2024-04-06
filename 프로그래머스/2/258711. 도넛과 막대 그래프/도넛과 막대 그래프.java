import java.util.*;

class Solution {
    
    int maxNodeCnt;
    boolean[] visited;
    int[] in;
    int[] out;
    int[] answer = new int[4];
    
    public int[] solution(int[][] edges) {
        init(edges);
        answer[0] = searchStartVertex();
        answer[2] = calcMakdae();
        answer[3] = calcPalja();
        answer[1] = out[answer[0]] - (answer[2] + answer[3]);
        
        return answer;
    }
    
    public int calcPalja() {
        int cnt = 0;
        for (int i = 1; i < maxNodeCnt; i++) {
            if (!visited[i] && in[i] >= 2 && out[i] >= 2) {
                cnt++;
            }
        }
        return cnt;
    }
    
    public int calcMakdae() {
        int cnt = 0;
        for (int i = 1; i < maxNodeCnt; i++) {
            if (in[i] >= 1 && out[i] == 0) {
                cnt++;
                visited[i] = true;
            }
        }
        return cnt;
    }
    
    public void init(int[][] edges) {
        for (int[] edge : edges) {
            maxNodeCnt = Math.max(maxNodeCnt, Math.max(edge[0], edge[1]));
        }
        maxNodeCnt++;
        visited = new boolean[maxNodeCnt];
        in = new int[maxNodeCnt];
        out = new int[maxNodeCnt];
        
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            out[a]++;
            in[b]++;
        }
    }
    
    public int searchStartVertex() {
        for (int i = 1; i < maxNodeCnt; i++) {
            if (out[i] >= 2 && in[i] == 0) {
                visited[i] = true;
                return i;
            }
        }
        return -1;
    }
}