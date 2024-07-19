import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        String str = br.readLine();
        String bombStr = br.readLine();
        int strLen = str.length();
        int bombLen = bombStr.length();

        for (int i = 0; i < strLen; i++) {
            stack.push(str.charAt(i));

            if (stack.size() >= bombLen) {
                StringBuilder sb = new StringBuilder();;
                boolean flag = true;

                for (int j = 0; j < bombLen; j++) {
                    if (stack.get(stack.size() - bombLen + j) != bombStr.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < bombLen; j++) {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) sb.append(c);
            System.out.println(sb);
        }
    }
}