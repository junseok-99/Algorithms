import java.util.*;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};
        
        int lcmNum = lcm(denom1, denom2);
        int afterNumer1 = lcmNum / denom1 * numer1;
        int afterNumer2 = lcmNum / denom2 * numer2;
        int sum = afterNumer1 + afterNumer2;
        int gcdNum = gcd(sum, lcmNum);
        
        return new int[]{sum / gcdNum, lcmNum / gcdNum};
    }
    
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}