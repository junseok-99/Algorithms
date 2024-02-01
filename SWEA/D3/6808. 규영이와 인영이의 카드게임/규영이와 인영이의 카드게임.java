import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();
    static int[] kyuYoung;
    static int[] inYoung;
    static int[] cards = new int[9];
    static boolean[] check;
    static boolean[] visited;
    static int win;
    static int lose;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            win = 0;
            lose = 0;
            check = new boolean[19];
            visited = new boolean[9];
            kyuYoung = new int[9];
            inYoung = new int[9];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 9; i++) {
                kyuYoung[i] = Integer.parseInt(st.nextToken());
                check[kyuYoung[i]] = true;
            }

            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!check[i]) {
                    inYoung[idx++] = i;
                }
            }

            dfs(0);

            sb.append("#" + tc + " " + win + " " + lose + "\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == 9) {
            int gameResult = isWin();
            win += (gameResult == 1 ? 1 : 0);
            lose += (gameResult == -1 ? 1 : 0);
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            cards[depth] = inYoung[i];
            dfs(depth + 1);
            visited[i] = false;
        }
    }

    // -1 : 패배, 0 : 무승부, 1 : 승리
    public static int isWin() {
        Integer kyu = 0;
        Integer in = 0;
        for (int i = 0; i < 9; i++) {
            int kyuRecord = kyuYoung[i];
            int inRecord = cards[i];
            int sum = kyuRecord + inRecord;
            kyu += (kyuRecord > inRecord ? sum : 0);
            in += (inRecord > kyuRecord ? sum : 0);
        }
        return kyu.compareTo(in);
    }
}