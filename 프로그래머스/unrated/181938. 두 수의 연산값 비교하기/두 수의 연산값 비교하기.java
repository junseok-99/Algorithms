class Solution {
    public int solution(int a, int b) {
        int left = Integer.parseInt(Integer.toString(a)+Integer.toString(b));
        int right = 2*a*b;
        return left <= right ? right : left;
    }
}