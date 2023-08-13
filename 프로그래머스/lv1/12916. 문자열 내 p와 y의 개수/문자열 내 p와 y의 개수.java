class Solution {
    boolean solution(String s) {
        int p = 0, y = 0;
        
        for(int i=0;i<s.length();i++){
            if(Character.toLowerCase(s.charAt(i)) == 'p') p++;
            else if(Character.toLowerCase(s.charAt(i)) == 'y') y++;
        }
        return p == y ? true : false;
    }
}