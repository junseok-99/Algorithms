import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;

class Solution {
    
    public int openBox(int[] cards, int startIndex) {
        Stack<Integer> tmp = new Stack<>();
        
        while(cards[startIndex] != -1) {
                tmp.push(cards[startIndex]);
                cards[startIndex] = -1;
                startIndex = tmp.peek() - 1;
            }
        
        return tmp.size();
    }
    
    public int solution(int[] cards) {
        int answer = 1;
        int idx = 0;
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<cards.length;i++) {
            int startIndex = i;
            
            if(cards[i] == -1) {
                continue;
            }
            
            int num = openBox(cards, startIndex);
            
            if (num != 0) {
                list.add(num);
            }
            
        }
        
        if (list.size() == 1) {
            return 0;
        }
        
        Collections.sort(list, Collections.reverseOrder());
        answer = list.get(0) * list.get(1);
        
        return answer;
    }
}