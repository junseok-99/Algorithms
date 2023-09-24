import java.io.*;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] boxs = new int[N];

        for(int idx=0;idx<M;idx++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for(int t=i-1;t<j;t++) {
                boxs[t] = k;
            }
        }

        for(int i=0;i<N;i++) {
            System.out.print(boxs[i] + " ");
        }
    }

}
