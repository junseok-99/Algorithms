import java.io.*;
import java.util.*;

/**
 * 백준 1744번 수 묶기
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int minus = 0;
        int plus = 0;
        int answer = 0;

        for(int i=0;i<N;i++) {
            int n = Integer.parseInt(br.readLine());
            
            if(n <= 0) {
                ++minus;
            } else {
                ++plus;
            }
            nums[i] = n;
        }

        Arrays.sort(nums);

        if(minus % 2 != 0) {
            answer += nums[minus-1];
        }

        if(plus % 2 != 0) {
            answer += nums[N-plus];
        }

        minus /= 2;
        plus /= 2;

        for(int i=0;minus > 0;i+=2) {
            answer += (nums[i]*nums[i+1]);
            minus-=1;
        }

        for(int i=N-1;plus > 0;i-=2) {
            if(nums[i] == 1 || nums[i-1] == 1) {
                answer += (nums[i]+nums[i-1]);
            } else {
                answer += (nums[i] * nums[i - 1]);
            }
            plus-=1;
        }

        System.out.println(answer);

    }
}