import java.util.*;

class Solution {
    Set<int[]> set = new HashSet<>();
    int sx = 0;
    int sy = 0;
    int ex = 0;
    int ey = 0;
    
    public void move(Character command) {
        
        if (command == 'U') {
            ey = sy + 1 > 5 ? 5 : sy + 1;
        } else if (command == 'D') {
            ey = sy - 1 < -5 ? -5 : sy - 1;
        } else if (command == 'L') {
            ex = sx - 1 < -5 ? -5 : sx - 1;
        } else if (command == 'R') {
            ex = sx + 1 > 5 ? 5 : sx + 1;
        }
        
        if (sx == ex && sy == ey) {
            return;
        }
        
        int[] tmp = new int[]{sx, sy, ex, ey};
        int[] tmp2 = new int[]{ex, ey, sx, sy};
        
        sx = ex;
        sy = ey;
        
        for(int[] pos: set) {
            if (Arrays.equals(pos, tmp) || Arrays.equals(pos, tmp2)) {
                return;
            }
        }
        set.add(Arrays.copyOf(tmp, 4));
    }
    
    public int solution(String dirs) {
        int answer = 0;
        
        for(int i=0;i<dirs.length();i++) {
            move(dirs.charAt(i));
        }
        
        return set.size();
    }
}