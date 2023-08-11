import java.util.*;

class Solution {
    int max_depth;
    Set<Integer> nums = new HashSet<>();
    boolean[] v;
    
    public int sosu(int num){
        
        if(num <= 1) return 0;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0) return 0;
        }
        return 1;
    }
    
    public void BT(int depth, String tmp, String n){
        if(depth == max_depth){
            nums.add(Integer.parseInt(n));
            return;
        }
        for(int i=0;i<max_depth;i++){
            if(!v[i]){
                v[i] = true;
                if(!n.equals("")) nums.add(Integer.parseInt(n));
                BT(depth+1, tmp, n+Character.toString(tmp.charAt(i)));
                v[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        int answer = 0;
        
        max_depth = numbers.length();
        v = new boolean[numbers.length()];
        BT(0,numbers,"");
        
        Iterator<Integer> it = nums.iterator();
        while(it.hasNext()){
            answer += sosu(it.next());
        }
        
        return answer;
    }
}