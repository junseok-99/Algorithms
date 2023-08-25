class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int num = 1, tmp = 0,i;
        boolean ck = false;
        
        while(true){
            ck = true;
            tmp = num * arr[arr.length-1];
            
            for(i=0;i<arr.length-1;i++){
                if(tmp % arr[i] != 0){
                    ck = false;
                    break;
                }
            }
            if(ck)
                break;
            
            num++;
        }
        return tmp;
        
    }
}