import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        int len = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIdx = 0;
        int bIdx = 0;
        
        while (aIdx < len && bIdx < len) {
            if (A[aIdx] < B[bIdx]) {
                ++answer;
                ++aIdx;
                ++bIdx;
            } else {
                ++bIdx;
            }
        }
        
        return answer;
    }
}