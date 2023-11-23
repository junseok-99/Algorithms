import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int[][] letters = new int[200001][26];

        for (int i=0;i<s.length();i++) {
            int letter = s.charAt(i) - 'a';
            letters[i+1] = letters[i].clone();
            letters[i+1][letter] = letters[i][letter] + 1;
        }

        for (int i=0;i<q;i++) {
            st  = new StringTokenizer(br.readLine());
            int letter = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken()) + 1;

            System.out.println(letters[r][letter] - letters[l][letter]);
        }

    }
}