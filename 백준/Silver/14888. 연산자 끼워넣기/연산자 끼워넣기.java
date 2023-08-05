import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] visited;
    static List<Character> operlist = new ArrayList<>();
    static Character[] opers = {'+', '-', '*', '/'};
    static int maxNum = -1000000001;
    static int minNum = 1000000001;

    public static int calc(Stack<Character> q, int[] nums, int n) {
        int ret = nums[0];

        for(int i=1;i<n;i++) {
            int op = q.get(i-1);

            if (op == '+') {
                ret += nums[i];
            } else if (op == '-') {
                ret -= nums[i];
            } else if (op == '*') {
                ret *= nums[i];
            } else if (op == '/') {
                ret /= nums[i];
            }
        }

        return ret;
    }

    public static void bt(Stack<Character> st, int depth, int n, int[] nums) {
        if (depth == n-1) {
            int ret = calc(st, nums, n);
            maxNum = Math.max(maxNum, ret);
            minNum = Math.min(minNum, ret);
            return;
        }

        for(int i=0;i<n-1;i++) {
            if (!visited[i]) {
                visited[i] = true;
                st.push(operlist.get(i));
                bt(st, depth + 1, n, nums);
                st.pop();
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        visited = new boolean[n-1];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<4;i++) {
            int cnt = Integer.parseInt(st.nextToken());
            for(int j=0;j<cnt;j++) {
                operlist.add(opers[i]);
            }
        }

        bt(new Stack<>(), 0, n, nums);

        System.out.println(maxNum);
        System.out.println(minNum);
    }
}
