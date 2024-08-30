class Solution {
    public String solution(String s) {
        String answer = "";

        String[] tmp = s.split(" ");
        int mi = Integer.parseInt(tmp[0]), mx = Integer.parseInt(tmp[0]);
        
        for(int i = 1;i<tmp.length;i++){
            mi = Math.min(mi, Integer.parseInt(tmp[i]));
            mx = Math.max(mx, Integer.parseInt(tmp[i]));
        }
        answer += Integer.toString(mi) + " " + Integer.toString(mx);
        System.out.println(answer);
        
        return answer;
    }
}