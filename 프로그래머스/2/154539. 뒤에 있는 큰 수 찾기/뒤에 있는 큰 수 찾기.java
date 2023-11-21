import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer,-1);
        Stack<Integer> st = new Stack<>();
        st.add(0);
        
        for(int i=1;i<numbers.length;i++){
            while(!st.isEmpty()){
                int idx = st.pop();
                if(numbers[idx] < numbers[i])
                    answer[idx] = numbers[i];
                else{
                    st.push(idx);
                    break;
                }
            }
            st.push(i);
        }
        
        return answer;
    }
}