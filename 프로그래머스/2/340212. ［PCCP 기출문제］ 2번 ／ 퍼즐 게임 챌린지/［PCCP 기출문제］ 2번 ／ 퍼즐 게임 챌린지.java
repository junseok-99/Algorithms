class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = -1;
        long minTime = Long.MAX_VALUE;
        
        int l = 1, r = 300_000;
        while (l < r) {
            int mid = (l + r) / 2;
            long time = getSolveTime(diffs, times, limit, mid);
            
            if (time == Long.MAX_VALUE) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
    
    // level로 했을 때 시간 구하기
    public long getSolveTime(int[] diffs, int[] times, long limit, int level) {
        long prev = 0L;
        long solveTime = 0L;
        
        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            long time = (long) times[i];
            
            if (diff <= level) {
                solveTime += time;
            } else {
                int repeat = diff - level;
                solveTime += (prev + time) * repeat + time;
            }
            if (solveTime > limit) return Long.MAX_VALUE;
            prev = time;
        }
        return solveTime;
    }
    
}