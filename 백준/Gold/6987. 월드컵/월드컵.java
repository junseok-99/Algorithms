import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean isSuccess;
    static int[][] matchInfo = new int[][] {
            {0,1},
            {0,2},
            {0,3},
            {0,4},
            {0,5},
            {1,2},
            {1,3},
            {1,4},
            {1,5},
            {2,3},
            {2,4},
            {2,5},
            {3,4},
            {3,5},
            {4,5},
    };
    static int[][] inputs = new int[6][3];
    static int[][] results = new int[6][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        IN: for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                inputs[j][0] = Integer.parseInt(st.nextToken());
                inputs[j][1] = Integer.parseInt(st.nextToken());
                inputs[j][2] = Integer.parseInt(st.nextToken());
                int sum = inputs[j][0] + inputs[j][1] + inputs[j][2];

                if (sum != 5) {
                    sb.append(0).append(' ');
                    continue IN;
                }
            }
            isSuccess = false;
            dfs(0);

            sb.append(isSuccess ? 1 : 0).append(' ');
        }
        System.out.println(sb);
    }

    public static void dfs(int cnt) {
        if (cnt == 15) {
            isSuccess = true;
            return;
        }

        int home = matchInfo[cnt][0];
        int away = matchInfo[cnt][1];

        //승리
        if (results[home][0] < inputs[home][0] && results[away][2] < inputs[away][2]) {
            results[home][0]++;
            results[away][2]++;
            dfs(cnt + 1);
            results[home][0]--;
            results[away][2]--;
            if (isSuccess) return;
        }

        //무
        if (results[home][1] < inputs[home][1] && results[away][1] < inputs[away][1]) {
            results[home][1]++;
            results[away][1]++;
            dfs(cnt + 1);
            results[home][1]--;
            results[away][1]--;
            if (isSuccess) return;
        }

        //패배
        if (results[home][2] < inputs[home][2] && results[away][0] < inputs[away][0]) {
            results[home][2]++;
            results[away][0]++;
            dfs(cnt + 1);
            results[home][2]--;
            results[away][0]--;
        }
    }
}