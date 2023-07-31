import java.io.*;
import java.util.Arrays;

public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String str = br.readLine().toUpperCase();

            int[] alphabets = new int[26];
            int maxnum = -1;
            int maxidx = -1;

            for(int i=0;i<str.length();i++) {
                int idx = (int)str.charAt(i) - 'A';
                ++alphabets[idx];
                if(maxnum < alphabets[idx]) {
                    maxnum = alphabets[idx];
                    maxidx = idx;
                }
            }
            bw.write(Character.toString((char)(maxidx + 'A')));

            int cnt = 0;

            for(int i=0;i<26;i++) {
                if(maxnum == alphabets[i]) {
                    ++cnt;
                    if(cnt > 1) {
                        bw = new BufferedWriter(new OutputStreamWriter(System.out));
                        bw.write("?");
                    }
                }
            }

            bw.flush();
            bw.close();
        }
}
