import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i=0;i<N;i++) {
            String str = br.readLine();
            Set<Character> set = new HashSet<>();

            int idx = 0;
            int len = str.length();
            boolean flag = true;

            while(idx < len) {
                char c = str.charAt(idx);

                if(set.contains(c)) {
                    flag = false;
                    break;
                }
                set.add(c);

                while(idx < len && str.charAt(idx) == c) {
                    idx++;
                }
            }

            if(flag) {
                cnt++;
            }

        }

        System.out.println(cnt);

    }
}
