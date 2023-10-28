class Solution {
    private int cnt = 0;
    
    public void change_one(int num){
        if(num==1) return;
        
        if(num%2==0) change_one(num/2);
        else change_one((num-1)/2);
        
        cnt++;
    }
    
    public int solution(int[] num_list) {
        for(int n: num_list) 
            change_one(n);
        
        return cnt;
    }
}