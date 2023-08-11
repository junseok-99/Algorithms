import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> s = new Stack<Integer>();
        int[] answer = new int[prices.length];
        
        int garbage;
        
        for(int i=0;i<prices.length;i++){
            garbage = 1;
            if(s.isEmpty()) s.push(i);
            else{
                while(!s.isEmpty() && prices[s.peek()]>prices[i]){
                    int tmp = s.pop();
                    answer[tmp] = i-tmp;
                }
                s.push(i);
            }
        }
        int top = s.pop();
        while(!s.isEmpty()){
            int tmp = s.pop();
            answer[tmp] = top-tmp;
        }
        
        
        return answer;
    }
}