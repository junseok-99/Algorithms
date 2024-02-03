import java.util.*;

class Solution {
    
    String[] tmp = {"+", "-", "*"};
    boolean[] v = new boolean[3];
    long answer = -1;
    String expression;
    
    public long solution(String expression_) {

        expression = expression_;
        dfs(0, new String[]{"","",""});
        
        return answer;
    }
    
    public void dfs(int depth, String[] opers) {
        if (depth == 3) {
            answer = Math.max(answer, calcExpression(expression, opers));
        }

        for(int i=0;i<3;i++) {
            if (!v[i]) {
                v[i] = true;
                opers[depth] = tmp[i];
                dfs(depth+1, opers);
                v[i] = false;
            }
        }
    }

    public long calcExpression(String expression, String[] operators) {

        Stack<String> st = new Stack<>();
        Queue<String> q = makeExpression(expression);

        for(int i=0;i<3;i++) {
            int size = q.size();
            Queue<String> tmp = new LinkedList<>();
            while(!q.isEmpty()) {
                if (q.peek().equals(operators[i])) {
                    st.push(calc(st.pop(), q.poll(), q.poll()));
                } else {
                    if (isNumeric(q.peek())) {
                        st.push(q.poll());
                    } else {
                        tmp.add(st.pop());
                        tmp.add(q.poll());
                    }
                }
            }

            while (!st.isEmpty()) {
                tmp.add(st.pop());
            }
            
            q = tmp;
        }

        return Math.abs(Long.parseLong(q.poll()));
    }

    public String calc(String a, String oper, String b) {
        if (oper.equals("+")) {
            return Long.toString(Long.parseLong(a) + Long.parseLong(b));
        } else if (oper.equals("-")) {
            return Long.toString(Long.parseLong(a) - Long.parseLong(b));
        }
        return Long.toString(Long.parseLong(a) * Long.parseLong(b));
    }

    public Queue<String> makeExpression(String expression) {

        Queue<String> q = new LinkedList<>();
        String num = "";

        for(char c: expression.toCharArray()) {
            if (Character.isDigit(c)) {
                num += Character.toString(c);
                continue;
            }
            q.add(num);
            num = "";
            q.add(Character.toString(c));
        }
        q.add(num);

        return q;
    }

    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}