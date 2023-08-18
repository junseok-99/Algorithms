class Solution {
    public String change(int n1, int n2){
        String tmp = "";
        String[] ref = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        if(n1==0) return "0";
        while(n1>0){
            tmp = ref[n1%n2] + tmp;
            n1 /= n2;
        }
        return tmp;
    }
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int num = 0;
        int cnt = 0;
        while(t>0){
            String tmp = change(num, n);
            for(int i=0;i<tmp.length();i++){
                if(cnt % m == p-1){
                    answer += Character.toString(tmp.charAt(i));
                    t-=1;
                    if(t==0) break;
                }
                cnt++;
            }
            num++;
        }
        return answer;
    }
}