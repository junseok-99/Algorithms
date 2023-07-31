class Solution {
    public int solution(int a, int b) {
        int n1 = Integer.parseInt(Integer.toString(a)+Integer.toString(b));
        int n2 = Integer.parseInt(Integer.toString(b)+Integer.toString(a));
        return n1 >= n2 ? n1 : n2;
    }
}