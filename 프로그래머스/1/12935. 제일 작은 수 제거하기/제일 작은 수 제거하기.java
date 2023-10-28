import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        if(arr.length == 1) answer = new int[]{-1};
        else{
            int size = arr.length-1;
            int[] min = {-1,Integer.MAX_VALUE};
            for(int i=0;i<size+1;i++){
                if(Math.min(arr[i],min[1]) != min[1]){
                    min[0] = i;
                    min[1] = arr[i];
                }
            }
           
            answer = new int[size];
            int j = 0;
            for(int i=0;i<size;i++){
                if(j != min[0]) answer[i] = arr[j];
                else i -= 1;
                j++;
            }
        }
        return answer;
    }
}