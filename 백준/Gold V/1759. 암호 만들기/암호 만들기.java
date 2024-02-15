import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int L;
    static int R;
    static char[] word;
    static char[] chars;
    static Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        word = new char[L];
        chars = new char[R];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(chars);

        combi(0, 0, 0, 0);
        System.out.println(sb.toString());

    }

    public static void combi(int idx, int depth, int moeum, int jaeum) {
        if (depth == L) {
            //System.out.println(new String(word) + "");
            if (moeum >= 1 && jaeum >= 2) {
                sb.append(new String(word)).append("\n");
            }
            return;
        }

        for (int i = idx; i < R; i++) {
            word[depth] = chars[i];
            int mo = set.contains(chars[i]) ? 1 : 0;
            int ja = !set.contains(chars[i]) ? 1 : 0;
            combi(i + 1, depth + 1, moeum + mo, jaeum + ja);
        }
    }
}