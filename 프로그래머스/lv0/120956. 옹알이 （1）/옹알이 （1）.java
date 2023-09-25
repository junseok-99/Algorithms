class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] voices = {"aya", "ye", "woo", "ma"};
        
        for(String b: babbling) {
            for(String voice: voices) {
                b = b.replace(voice, "-");
            }
            
            boolean flag = true;
            for(int i=0;i<b.length();i++) {
                if (b.charAt(i) != '-') {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                ++answer;
            }
        }
        
        return answer;
    }
}