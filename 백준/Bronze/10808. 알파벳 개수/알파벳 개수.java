import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = new int[26];

        String s = br.readLine();

        for (int i=0;i<s.length();i++) {
            nums[(int)s.charAt(i) - (int)'a']++;
        }

        for(int i=0;i<nums.length;i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
