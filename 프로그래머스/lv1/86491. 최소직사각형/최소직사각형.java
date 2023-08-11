class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int[] max = new int[2];
        
        for(int[] a: sizes){
            if(a[0]<a[1]){
                max[0] = Math.max(a[1],max[0]);
                max[1] = Math.max(a[0],max[1]);
            }
            else{
                max[0] = Math.max(a[0],max[0]);
                max[1] = Math.max(a[1],max[1]);
            }
        }
        return max[0]*max[1];
    }
}