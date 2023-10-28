class Solution {
    public int calc(int num, int k){
        int sum = 0;
        while(num>0){
            if(num%10==k) sum++;
            num/=10;
        }
        return sum;
    }
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(i=i;i<=j;i++)
            answer += calc(i,k);
        return answer;
    }
}