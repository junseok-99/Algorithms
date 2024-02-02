import java.util.*;

class Solution {
    public int solution(String name) {
        int len = name.length();
        String s = "A".repeat(len);
        int minChangePrice = 0;
        int minMovePrice = len - 1;
        int answer = 0;
        
        for (int i = 0; i < len; i++) {
            minChangePrice += calcChangeCharPrice(name.charAt(i));
            
            int endAIdx = i + 1;
            while (endAIdx < len && name.charAt(endAIdx) == 'A') {
                endAIdx++;
            }
            
            minMovePrice = Math.min(minMovePrice, calcChangePosPrice(i, endAIdx, len));
        }
        answer = minChangePrice + minMovePrice;

        return answer;
    }
    
    public int calcChangeCharPrice(char after) {
        return Math.min(after - 'A', 'Z' - after + 1);
    }
    
    public int calcChangePosPrice(int start, int end, int len) {
       
        //1 왼쪽 갔다가 오른쪽으로 넘어가는거
        int rPrice = (start * 2) + len - end;
        //2 오른쪽 갔다가 왼쪽으로 넘어가는거
        int lPrice = (len - end) * 2 + start;
        return Math.min(rPrice, lPrice);
    }
}