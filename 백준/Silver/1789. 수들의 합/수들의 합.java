import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        long answer = 1;
        
        if(n==1 || n==2) {
            bw.write("1");
            bw.flush();
            bw.close();
            return;
        }
        for(long i=1L;i<n;i++) {
            long sum = (i+1)*(i) / 2;
            if(sum > n) {
                bw.write(i-1+"");
            } else if(sum == n) {
                bw.write(i+"");
            } else {
                continue;
            }
            bw.flush();
            bw.close();
            return;
        }
    }
}
