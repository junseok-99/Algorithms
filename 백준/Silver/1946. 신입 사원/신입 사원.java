import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++) {
            int N = Integer.parseInt(br.readLine());
            int[] grades = new int[N];
            int answer = 1;

            for(int n=0;n<N;n++) {
                st = new StringTokenizer(br.readLine());
                grades[Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken())-1;
            }

            int tmp = grades[0];

            for(int i=1;i<N;i++) {
                if(tmp > grades[i]) {
                    tmp = grades[i];
                    ++answer;
                }
            }

            System.out.println(answer);
        }
    }
}

