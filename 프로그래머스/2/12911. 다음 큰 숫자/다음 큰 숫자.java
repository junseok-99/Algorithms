class Solution {
    public int solution(int n) {
        int answer = 0;
        int nCnt = Integer.toBinaryString(n).length() - Integer.toBinaryString(n).replace("1","").length();
        for(int i=n+1;i<1000000;i++){
            int npCnt = Integer.toBinaryString(i).length() - Integer.toBinaryString(i).replace("1","").length();
            if(nCnt == npCnt){
                answer = i;
                break;
            }
        }
        return answer;
    }
}