import java.util.ArrayList;

class Solution {
    public String solution(String s) {
        String ret ="";
        boolean ck = true;
        
        for(char tmp: s.toCharArray())
            ret += Character.toString(Character.toLowerCase(tmp));

        StringBuilder sb = new StringBuilder(ret);

        for(int i=0;i<ret.length();i++){
            char ts = ret.charAt(i);
            if (ts == ' '){
                ck = true;
                continue;
            }
                
            if (ck){
                if(Character.isLetter(ts))
                    sb.setCharAt(i, Character.toUpperCase(ts));
                ck = false;
            }
        }
        ret = String.valueOf(sb);
        
        return ret;
        
    }
}