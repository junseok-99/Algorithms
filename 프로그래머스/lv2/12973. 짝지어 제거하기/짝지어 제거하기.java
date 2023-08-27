import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> st = new Stack<>();
        
        for(char tmp: s.toCharArray()){
            if(st.empty())
                st.push(tmp);
            else if(st.peek() == tmp)
                st.pop();
            else
                st.push(tmp);
            
        }
        if (st.empty()) return 1;
        return 0;
    }
}