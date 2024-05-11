import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        boolean cFlag = false;

        if (isC(s)) {
            for (char c : s.toCharArray()) {

                if (c == '_') {
                    cFlag = true;
                    continue;
                }

                if (cFlag) {
                    sb.append(Character.toUpperCase(c));
                    cFlag = false;
                } else {
                    sb.append(c);
                }
            }
        } else if (isJava(s)) {
            for (char c : s.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    sb.append("_");
                    sb.append(Character.toLowerCase(c));
                } else {
                    sb.append(c);
                }
            }
        } else {
            sb.append("Error!");
        }

        System.out.println(sb);
    }

    public static boolean isC(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                return false;
            }

            if (c == '_') {
                if (i == 0 || i == s.length() - 1) {
                    return false;
                }
                char l = s.charAt(i - 1);
                char r = s.charAt(i + 1);
                if (l == '_' || r == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isJava(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            return false;
        }

        for (char c : s.toCharArray()) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
}