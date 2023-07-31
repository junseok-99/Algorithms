import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            int len = str.length();
            int[] alphas = new int[26];
            boolean flag = false;
            final String miss = "I'm Sorry Hansoo";

            StringBuilder front = new StringBuilder();
            StringBuilder mid = new StringBuilder();
            StringBuilder back = new StringBuilder();

            for(int i=0;i<len;i++) {
                ++alphas[(int)str.charAt(i) - 65];
            }

            for(int i=0;i<26;i++) {
                if (alphas[i] == 0) {
                    continue;
                }
                String s = Character.toString((char)(i+65));

                if(!flag && alphas[i]%2 != 0) {
                    mid.append(s.repeat(alphas[i]%2));
                    flag = true;
                } else if(flag && alphas[i]%2 != 0) {
                    System.out.println(miss);
                    return;
                }

                front.append(s.repeat(alphas[i]/2));
                back.append(s.repeat(alphas[i]/2));
            }

            front.append(mid.toString());
            front.append(back.reverse().toString());

            System.out.println(front.toString());
    }
}
