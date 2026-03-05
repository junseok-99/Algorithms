import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        Score[] scores = new Score[6];
        
        for (int i = 0; i < 6; i++) {
            scores[i] = new Score(i + 1, 0);
        }
        
        scores[a - 1].cnt++;
        scores[b - 1].cnt++;
        scores[c - 1].cnt++;
        scores[d - 1].cnt++;
        
        Arrays.sort(scores, (a1, b1) -> b1.cnt - a1.cnt);
        
        int cnt1 = scores[0].cnt;
        
        if (cnt1 == 4) return 1111 * scores[0].n;
        else if (cnt1 == 3) return (int) Math.pow(10 * scores[0].n + scores[1].n, 2);
        else if (cnt1 == 2) {
            if (scores[1].cnt == 2) return (scores[0].n + scores[1].n) * Math.abs(scores[0].n - scores[1].n);
            return scores[1].n * scores[2].n;
        }
        else if (cnt1 == 1) return Arrays.stream(scores, 0, 4)
                 .min(Comparator.comparingInt(o -> o.n))
                 .get()
                 .n;
        
        return 0;
    }
}

class Score {
    int n;
    int cnt;
    
    Score(int n, int cnt) {
        this.n = n;
        this.cnt = cnt;
    }
    
    @Override
    public String toString() {
        return n + " | " + cnt;
    }
    
}