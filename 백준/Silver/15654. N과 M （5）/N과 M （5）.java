import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static String[] nums;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nums = new String[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            nums[i] = st.nextToken();
        }
        Arrays.sort(nums, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });
        
        bt(0, N, M, "");

    }

    public static void bt(int depth, int N, int M, String str) {
        if (depth == M) {
            System.out.println(str);
            return;
        }

        for(int i=0;i<N;i++) {
            if (!visited[i]) {
                visited[i] = true;
                bt(depth + 1, N, M, str + nums[i] + " ");
                visited[i] = false;
            }
        }
    }
}
