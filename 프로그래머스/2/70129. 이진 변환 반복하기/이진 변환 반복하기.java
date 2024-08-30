class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};

        while(!s.equals("1")){
            String tmp = "";
            for(int i=0;i<s.length();i++)
                if(s.charAt(i) == '1') tmp += "1";
                else answer[1]++;
            
            s = Integer.toBinaryString(tmp.length());
            answer[0]++;
        }
        return answer;
    }
}