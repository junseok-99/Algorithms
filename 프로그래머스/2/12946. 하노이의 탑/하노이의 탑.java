class Solution {
    private int idx = 0;

    public int[][] solution(int n) {
        int num = (int)Math.pow(2, n) - 1;
        int[][] answer = new int[num][2];
        hanoi(answer, n, 1, 2, 3);
        return answer;
    }
    
    public void hanoi(int[][] answer, int num, int fromA, int midB, int toC) {
        if (num == 1) {
            answer[idx][0] = fromA;
            answer[idx++][1] = toC;
            return;
        }
        hanoi(answer, num - 1, fromA, toC, midB);

        answer[idx][0] = fromA;
        answer[idx++][1] = toC;

        hanoi(answer, num - 1, midB, fromA, toC);
    }
}