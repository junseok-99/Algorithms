import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int l = num_list.length;
        int[] answer = Arrays.copyOf(num_list, l+1);
        answer[l] = num_list[l-2] < num_list[l-1] ? num_list[l-1]-num_list[l-2] : num_list[l-1]*2;
        return answer;
    }
}