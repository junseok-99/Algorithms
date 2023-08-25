import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        int sum = 0;
        
        for(int i=0;i<want.length;i++) {
            map.put(want[i], map.getOrDefault(want[i], 0) + number[i]);
            sum += number[i];
        }
        
        for(int i=0;i<discount.length;i++) {
            Map<String, Integer> tmp = new HashMap<>();
            int tmpSum = sum;
            int cnt = 0;
            
            for(String s: map.keySet()) {
                tmp.put(s, map.get(s));
            }
            
            for(int j=i;j<discount.length;j++, cnt++) {
                String food = discount[j];
                if(map.containsKey(food) && map.get(food) > 0) {
                    map.put(food, map.get(food) - 1);
                    sum--;
                }
                
                if(sum == 0) {
                    break;
                }
            }
            
            if(sum == 0 && cnt+1 <= 10) {
                ++answer;
            }
            
            map = tmp;
            sum = tmpSum;
        }
       
        return answer;
    }
}