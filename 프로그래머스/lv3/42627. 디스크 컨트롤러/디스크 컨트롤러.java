import java.util.PriorityQueue;

class Solution {
    private int completeTime;

    public int schedulerDispatch(PriorityQueue<int[]> queue, int currentTime) {

        int[] process = queue.poll();
        completeTime += (currentTime - process[0]) + process[1];
        currentTime += process[1];

        return currentTime;
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> readyProcessQueue = new PriorityQueue<>((p1,p2) -> p1[0]-p2[0]);
        PriorityQueue<int[]> runningProcessQueue = new PriorityQueue<>((p1,p2) -> p1[1]-p2[1]);

        int allProcessNum = jobs.length;

        completeTime = 0;

        for(int i=0;i<allProcessNum;i++) {
            readyProcessQueue.add(jobs[i]);
        }

        int currentTime = 0;

        while(!readyProcessQueue.isEmpty() || !runningProcessQueue.isEmpty()) {
            
            while(!readyProcessQueue.isEmpty() && currentTime >= readyProcessQueue.peek()[0]) {
                runningProcessQueue.add(readyProcessQueue.poll());
            }

            if(!runningProcessQueue.isEmpty()) {
                currentTime = schedulerDispatch(runningProcessQueue, currentTime);
            } else {
                ++currentTime;
            }

        }

        int averageTime = completeTime / allProcessNum;
        
        return averageTime;
    }
}