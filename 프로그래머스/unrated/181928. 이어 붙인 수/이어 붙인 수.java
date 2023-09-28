class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String odd = "";
        String even = "";
        
        for(int n: num_list)
            if(n%2==0) even += Integer.toString(n);
            else odd += Integer.toString(n);
        return Integer.parseInt(even)+Integer.parseInt(odd);
    }
}