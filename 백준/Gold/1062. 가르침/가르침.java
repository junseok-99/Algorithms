import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int K;
    static int answer;
    static Set<Character> set;
    static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];
        set = new HashSet<>(List.of('a', 'n', 't', 'c', 'i'));

        if (K < 5 || K == 26) {
            if (K == 26) answer = N;
            System.out.println(answer);
            return;
        }

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        K -= 5;
        dfs('a', 0);
        System.out.println(answer);
    }

    public static void dfs(char idx, int depth) {
        if (depth == K) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                boolean flag = true;
                for (int j = 4; j < words[i].length() - 4; j++) {
                    if (!set.contains(words[i].charAt(j))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) cnt++;
            }
            answer = Math.max(answer, cnt);
            return;
        }

        for (char c = idx; c <= 'z'; c++) {
            if (set.contains(c)) continue;
            set.add(c);
            dfs((char)((int)c + 1), depth + 1);
            set.remove(c);
        }
    }
}