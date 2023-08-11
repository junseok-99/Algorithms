class Solution {
    String[] s = {"A","E","I","O","U"};
    int cnt = 0;
    boolean ck = false;
    public void BackTracking(int depth, String word, String anw){
        cnt++;
        //System.out.println(word);
        if(depth == 5) return;
        for(int i=0;i<5;i++){
            if((word+s[i]).equals(anw)){
                ck = true;
                return;
            }
            if(ck) return;
            BackTracking(depth+1, word+s[i], anw);
        }
    }
    public int solution(String word) {
        BackTracking(0,"",word);
        return cnt;
    }
}