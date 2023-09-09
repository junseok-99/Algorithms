import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        Arrays.fill(answer, -1);
        int cnt = 0;
        
        for(int[] query: queries) {
            for(int i=query[0];i<=query[1];i++) {
                if (arr[i] > query[2]) {
                    if (answer[cnt] == -1 || answer[cnt] > arr[i])
                    answer[cnt] = arr[i];
                }
            }
            cnt++;
        }
        
        
        return answer;
    }
}