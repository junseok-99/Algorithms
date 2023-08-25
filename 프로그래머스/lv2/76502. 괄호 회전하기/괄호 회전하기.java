import java.util.Stack;

class Solution {
    
    public int solution(String s) {
        
        int ret = 0;
        int len = s.length();
        
        
        for(int i=0;i<len;i++){
            Stack<Character> st = new Stack<Character>();
            for(int j=i;j<i+len;j++){
                if(st.empty())
                    st.push(s.charAt(j%len));
                else{
                    char tmp = st.peek();
                    switch(tmp){
                        case '[':
                            if(s.charAt(j%len) == ']')
                                st.pop();
                            else
                                st.push(s.charAt(j%len));
                            break;
                        case '{':
                            if(s.charAt(j%len) == '}')
                                st.pop();
                            else
                                st.push(s.charAt(j%len));
                            break;
                        case '(':
                            if(s.charAt(j%len) == ')')
                                st.pop();
                            else
                                st.push(s.charAt(j%len));
                            break;
                        default:
                            st.push(s.charAt(j%len));
                            break;
                    }
                }
            }
            if(st.size() == 0)
                ret++;
        }
        
        return ret;
    }
}