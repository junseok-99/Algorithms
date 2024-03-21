import java.util.*;

class Solution {
    
    String[][] relation;
    int maxDepth;
    int row;
    int[] picked;
    int answer;
    
    public int solution(String[][] r) {
        maxDepth = r[0].length;
        picked = new int[maxDepth];
        row = r.length;
        relation = r;
        answer = 0;
        
        combi(0, 0);
        return answer == 0 ? 1 : answer;
    }
    
    public void combi(int idx, int depth) {
        if (depth == maxDepth) return;
        
        if (depth > 0) {
            boolean isUnique = checkUnique(depth, -1); //유일성
            boolean isMinimal = false;                  //최소성

            for (int i = 0; i < depth && depth > 1; i++) {
                isMinimal = checkUnique(depth, i); 
                if (isMinimal) break;
            }

            if (isUnique && !isMinimal) ++answer;
        }
        
        for (int i = idx; i < maxDepth; i++) {
            picked[depth] = i;
            combi(i + 1, depth + 1);
        }
    }
    
    public boolean checkUnique(int len, int removeIdx) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                if (j == removeIdx) continue;
                int col = picked[j];
                sb.append(relation[i][col]);
            }
            set.add(sb.toString());
        }
        if (set.size() == row) return true;
        return false;
    }
}