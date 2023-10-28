class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int size = phone_number.length();
        answer = phone_number.substring(size-4,size);
        for(int i=0;i<size-4;i++)
            answer = "*" + answer;
        return answer;
    }
}