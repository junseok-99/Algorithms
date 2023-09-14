class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        int num = b / gcd(a, b);
        
        while (num % 2 == 0) {
            num /= 2;
        }
        
        while (num % 5 == 0) {
            num /= 5;
        }
        
        if (num > 1) {
            return 2;
        }
        return 1;
    }
    
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}