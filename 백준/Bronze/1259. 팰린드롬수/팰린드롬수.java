import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();

            if (s.equals("0")) {
                return;
            }

            if (check(s)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public static boolean check(String s) {
        int end = s.length() - 1;

        for(int i=0;i<s.length() / 2;i++) {
            if (s.charAt(i) != s.charAt(end - i)) {
                return false;
            }
        }
        return true;
    }
}
