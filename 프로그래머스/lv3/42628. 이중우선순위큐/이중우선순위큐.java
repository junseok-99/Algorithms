import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> plusQueue = new PriorityQueue<>((o1,o2) -> o2 - o1);
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
        
        for(String oper: operations) {
            String[] tmp = oper.split(" ");
            int n = Integer.parseInt(tmp[1]);
            
            if (tmp[0].equals("I")) {
                if (n > 0) {
                    plusQueue.add(n);
                } else {
                    minusQueue.add(n);
                }
            } else if(tmp[0].equals("D")) {
                if (n == 1) {
                    while(!minusQueue.isEmpty()) {
                        plusQueue.add(minusQueue.poll());
                    }
                    if(!plusQueue.isEmpty()) {
                        plusQueue.poll();
                    } 
                } else if (n == -1 ) {
                    while(!plusQueue.isEmpty()) {
                         minusQueue.add(plusQueue.poll());
                    }
                    if(!minusQueue.isEmpty()) {
                        minusQueue.poll();
                    } 
                }
            }
        }
        
        while(!minusQueue.isEmpty()) {
            plusQueue.add(minusQueue.poll());
        }
        if(!plusQueue.isEmpty()){
            answer[0] = plusQueue.peek();
        }
            
        while(!plusQueue.isEmpty()) {
            minusQueue.add(plusQueue.poll());
        }
        if(!minusQueue.isEmpty()) {
            answer[1] = minusQueue.peek();
        }
        
        
        return answer;
    }
}