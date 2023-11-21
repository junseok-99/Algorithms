import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        
        int answer = 0;
        int length = targets.length;
        
        Arrays.sort(targets, (t1, t2) -> {
            if(t1[1] == t2[1]) {
                return t2[0] - t1[0];
            }
            return t1[1] - t2[1];
        });
        
        int left = -1;
        
        for(int i=0;i<targets.length;i++) {
            if(left <= targets[i][0]) {
                ++answer;
                left = targets[i][1];
            }
        }
        
        /*
        1 2 3 4 
            3 4 5 6 7
              4 5 
              4 5 6 7 8
                5 6 7 8 9 10 11 12 
                          10 11 12 13 14
                             11 12 13
        */
        
        return answer;
    }
}