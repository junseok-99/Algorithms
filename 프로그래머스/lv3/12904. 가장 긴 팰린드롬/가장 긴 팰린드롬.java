class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        int l = 0;
        int r = s.length() - 1;
        
        for(int i=0;i<s.length();i++) {
            l = i;
            r = s.length() - 1;
            int len = 0;
            int tmp = 0;
            int cnt = 1;
            
            while (l <= r) {
                char leftChar = s.charAt(l);
                char rightChar = s.charAt(r);
            
                if (leftChar == rightChar) {
                    if (l == r) {
                        tmp++;
                    } else {
                        ++len;
                    }
                    l++;
                    r--;
                } else {
                    len = 0;
                    l = i;
                    r = s.length() - cnt;
                    cnt++;
                }   
            }
            
            len = len * 2 + tmp;
            answer = Math.max(answer, len);
        }
        
        if (answer == 0) {
            return 1;
        }

        return answer;
    }
}