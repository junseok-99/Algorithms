import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int size = truck_weights.length;
        int cur_wei = 0;
        int cur_truck = 0;
        Queue<Integer> comp = new LinkedList<>();
        Queue<Integer> going = new LinkedList<>();
        Queue<Integer> wait = new LinkedList<>();

        for(int t: truck_weights)
            wait.add(t);
        for(int i=0;i<bridge_length-1;i++)
            going.add(0);

        while(size != comp.size()){
            int wait_size = wait.size();

            for(int i=0;i<wait_size;i++){
                int tmp = wait.peek();
                if(cur_truck<=bridge_length && cur_wei+tmp <= weight) {
                    cur_wei+=tmp;
                    going.add(wait.poll());
                    cur_truck++;
                }
                else {
                    break;
                }
            }
            int going_truck = going.poll();
            if(going.size()<bridge_length-1) going.add(0);
            if(going_truck>0){
                cur_wei -= going_truck;
                cur_truck--;
                comp.add(going_truck);
            }
            answer++;
        }

        return answer;
    }
}