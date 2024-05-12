class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int lastN = storey % 10;
            
            if (lastN > 5) {
                answer += (10 - lastN);
                storey += (10 - lastN);
            } else if (lastN < 5) {
                answer += lastN;
            } else {
                int afterLastN = (storey / 10) % 10;
                
                if (afterLastN >= 5) {
                    answer += (10 - lastN);
                    storey += (10 - lastN);
                } else {
                    answer += lastN;
                }
            }
            storey /= 10;
        }
        return answer;
    }
}