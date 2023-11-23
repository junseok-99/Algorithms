import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int[][] letters = new int[s.length() + 1][26];

        for (int i=0;i<s.length();i++) {
            int letter = s.charAt(i) - 'a';
            letters[i+1][letter]++;
            for (int j=0;j<26;j++) {
                letters[i+1][j] += letters[i][j];
            }
        }

        for (int i=0;i<q;i++) {
            st  = new StringTokenizer(br.readLine());
            int letter = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken()) + 1;

            bw.write(letters[r][letter] - letters[l][letter] + "\n");
        }
        bw.flush();
        bw.close();
    }
}