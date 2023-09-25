class Solution {
    public int solution(int[][] dots) {
        double m1 = Math.abs((double)dots[0][1]-dots[1][1]) / Math.abs((double)dots[0][0]-dots[1][0]);
        double m2 = Math.abs((double)dots[2][1]-dots[3][1]) / Math.abs((double)dots[2][0]-dots[3][0]);
        return m1==m2 ? 1 : 0;
       
    }
    
}