import java.util.*;

class Solution {
    
    Map<String, Integer> dic = new HashMap<>();
    
    public void InitDic() {
        for(char i='A';i<='Z';i++) {
            dic.put(Character.toString(i), (int)i - 64);
        }
    }
    
    public List<Integer> solution(String msg) {
        List<Integer> li = new LinkedList<>();
        int curValue = 27;
        int size = msg.length();
        
        InitDic();
        
        for(int i=0;i<size;i++) {
            int tmp = i + 1;
            
            while (true) {
                if (tmp == size) {
                    li.add(dic.get(msg.substring(i, tmp)));
                    i = tmp - 1;
                    break;
                }
                
                if (!dic.containsKey(msg.substring(i, tmp + 1))) {
                    dic.put(msg.substring(i, tmp + 1), curValue++);
                    li.add(dic.get(msg.substring(i, tmp)));
                    i = tmp - 1;
                    break;
                }
                
                tmp++;
            }
        }
        return li;
    }
}