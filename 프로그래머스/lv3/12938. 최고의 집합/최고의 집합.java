class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};
        
        int[] answer = new int[n];
        int size = n;
        while (n > 0) {
            answer[size - n] = s / n;
            s -= answer[size - n];
            n--;
        }
        
        return answer;
    }
}