import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        int[] map = new int[(int)(right - left + 1)];
        int cnt = 0;
        
        for(long i=left;i<=right;i++) {
            map[cnt++] = (int)Math.max(i / n, i % n) + 1;
        }

        return map;
    }
}