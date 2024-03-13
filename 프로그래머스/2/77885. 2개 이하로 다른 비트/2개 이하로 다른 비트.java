class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length;i++) {
            answer[i] = f(numbers[i]);
        }
        return answer;
    }
    
    public long f(long x) {
        if (x % 2 == 0) {
            return x + 1;
        }
        String binaryStr = "0" + Long.toBinaryString(x);
        String minBinaryStr = "";
        for (int i = binaryStr.length() - 1; i >= 0; i--) {
            if (binaryStr.charAt(i) == '0') {
                minBinaryStr += (binaryStr.substring(0, i) + "10" + binaryStr.substring(i +2, binaryStr.length()));
                break;           
            }
        }
        return Long.parseLong(minBinaryStr, 2);
    }
}