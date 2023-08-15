class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0], gcdB = arrayB[0];
        boolean flagA = true, flagB = true;
        
        for(int i=1;i<arrayA.length;i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        for(int i=0;i<arrayA.length;i++) {
            if (arrayA[i] % gcdA != 0 || arrayB[i] % gcdA == 0) {
                flagA = false;
            }
            if (arrayB[i] % gcdB != 0 || arrayA[i] % gcdB == 0) {
                flagB = false;
            }
        }
        
        if (flagA && flagB) {
            return Math.max(gcdA, gcdB);
        } else if (flagA) {
            return gcdA;
        } else if (flagB) {
            return gcdB;
        }
        return 0;
    }
    
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}