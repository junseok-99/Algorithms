import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Deque<Integer> progQue = new ArrayDeque<>();
        Deque<Integer> speedQue = new ArrayDeque<>();
        
        for (int prog: progresses) {
            progQue.add(prog);
        }
        
        for (int speed: speeds) {
            speedQue.add(speed);
        }
        
        int day = 1;
        
        while (!progQue.isEmpty()) {
            int ret = day * speedQue.peek();
            int cnt = 0;
            while (!progQue.isEmpty() && progQue.peek() + day * speedQue.peek() >= 100) {
                progQue.poll();
                speedQue.poll();
                cnt++;
            }
            if (cnt > 0) answer.add(cnt);
            
            day++;
        }
        return answer;
    }
}