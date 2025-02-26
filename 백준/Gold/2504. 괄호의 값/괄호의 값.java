import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();
        int v = 1;
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int score = c == '(' || c == ')' ? 2 : 3;
            if (c == '(' || c =='[') {
                stack.push(c);
                v *= score;
            } else {
                if (stack.isEmpty() || (stack.peek() != '(' && c == ')') || (stack.peek() != '[' && c == ']')) {
                    answer = 0;
                    break;
                }

                char prev = s.charAt(i - 1);
                if ((prev == '(' && c == ')') || (prev == '[' && c == ']')) answer += v;
                stack.pop();
                v /= score;
            }
        }//(((())())())
        if (!stack.isEmpty()) System.out.println(0);
        else System.out.println(answer);
    }
}