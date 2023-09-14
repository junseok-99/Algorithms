class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
        if (common[1] - common[0] == common[2] - common[1]) {
            int num = common[1] - common[0];
            return common[common.length - 1] + num;
        }
        
        int num1 = common[1] - common[0];
        int num2 = common[2] - common[1];
        int ret = num2 / num1;
        
        return common[common.length - 1] * ret;
    }
}