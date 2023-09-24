import java.io.*;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int end = s.length() - 1;
        for(int i=0;i<s.length()/2;i++) {
            if (s.charAt(i) != s.charAt(end - i)) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }
}
