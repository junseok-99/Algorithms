import java.util.*;

class Solution {
    public int calc(int[] fees, int time){
        int times = time - fees[0];
        if(times <= 0) return fees[1];
        times = times/fees[2] + (times%fees[2] > 0 ? 1:0);
        return times * fees[3] + fees[1];
    }
    
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, Integer> numbers = new HashMap<>();
        Map<String, Integer> fees_sum = new TreeMap<>();
        
        for(String r: records){
            String[] tmp = r.split(" ");
            int time = Integer.parseInt(tmp[0].substring(0,2))*60 + Integer.parseInt(tmp[0].substring(3,5));
            
            if(tmp[2].equals("IN")) //in
                numbers.put(tmp[1], time);
            else{ //out
                fees_sum.put(tmp[1], fees_sum.getOrDefault(tmp[1], 0) + time - numbers.get(tmp[1]));
                numbers.remove(tmp[1]);
            }
        }
        
        if(numbers.size() > 0){
            for(String key: numbers.keySet()){
                int time = (23*60 + 59) - numbers.get(key);
                fees_sum.put(key, fees_sum.getOrDefault(key,0)+time);
            }
        }
        
        for(String key: fees_sum.keySet())
            fees_sum.put(key, calc(fees, fees_sum.get(key)));
        
        int[] answer = new int[fees_sum.size()];
        int cnt = 0;
        
        for(String key: fees_sum.keySet())
            answer[cnt++] = fees_sum.get(key);
        
        return answer;
    }
}