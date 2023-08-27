import java.util.HashMap;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        
        for(int i=0;i<words.length;i++){
            
            if((i+1)%n==1)
                answer[1]++;
            
            if(hm.containsKey(words[i]) || (i>0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0))){
                answer[0] = (i+1)%n == 0 ? n : (i+1)%n;
                return answer;
            }
            else
                hm.put(words[i],1);
            
        }
        answer[0] = 0; answer[1] = 0;
        return answer;
    }
}