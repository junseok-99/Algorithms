import java.util.Iterator;
class Solution {
    
    public boolean ck(String s){
        Long tmp = Long.parseLong(s);
        if (tmp ==1) return false;
        for(int i=2;i<=(int)Math.sqrt(tmp);i++)
            if(tmp % i == 0)
                return false;
        return true;
    }
    
    public int solution(int n, int k) {
        Solution su = new Solution();
        int answer = 0;
        String a= "";
        
        while(n>0){
            a = Integer.toString(n%k) + a;
            n /= k;
        }
        String tmp = "";
        
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != '0')
                tmp += a.charAt(i);
            if(a.charAt(i) == '0' || i == a.length() - 1){
                if(!tmp.equals("") && su.ck(tmp))
                    answer++;
                tmp = "";
            }  
        }
        
        return answer;
    }
}