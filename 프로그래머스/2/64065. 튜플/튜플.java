import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int i = 0;
        
        s = s.substring(2,s.length());
        s = s.substring(0,s.length()-2).replace("},{","-");
        
        String[] tmp = s.split("-");
        Arrays.sort(tmp, (String s1, String s2) -> s1.length() - s2.length());
        
        for(String a:tmp){
            String[] tmp2 = a.split(",");
            for(String b:tmp2){
                int num = Integer.parseInt(b);
                if(!ret.contains(num))
                    ret.add(num);
            }
        }
        
        int[] answer = new int[ret.size()];
        for(int a: ret)
            answer[i++] = a;
        
        return answer;
    }
}