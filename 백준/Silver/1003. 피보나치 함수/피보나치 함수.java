import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] zero = new int[41];
        int[] one = new int[41];
        zero[0] = 1;
        one[1] = 1;

        for(int i=2;i<41;i++){
            zero[i] = zero[i-1] + zero[i-2];
            one[i] = one[i-1] + one[i-2];
        }
        for(int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(zero[n] + " " + one[n] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
