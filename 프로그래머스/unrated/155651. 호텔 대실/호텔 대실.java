import java.util.*;

class Solution {
    
    public int[] changeIntArr(String[] time) {
        int[] arr = new int[2];
        
        for(int i=0;i<2;i++) {
            String[] tmp = time[i].split(":");
            arr[i] = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
        }
        
        return arr;
    }
    
    public int solution(String[][] book_time) {
        
        int[][] times = new int[book_time.length][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<book_time.length;i++) {
            times[i] = changeIntArr(book_time[i]);
        }
        
        Arrays.sort(times, (t1, t2) -> {
           if(t1[0] == t2[0]) {
               return t1[1] - t2[1];
           }
            return t1[0] - t2[0];
        });
        
        pq.add(times[0][1]);
        
        for(int i=1;i<times.length;i++) {
            if(pq.peek() + 10 <= times[i][0] ) {
                pq.poll();
            }
            pq.add(times[i][1]);
        }
        
        return pq.size();
    }
}