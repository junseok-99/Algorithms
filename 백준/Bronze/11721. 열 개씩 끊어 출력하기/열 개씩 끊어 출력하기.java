import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int len = s.length();

        for(int i=0;i<len;i+=10) {
            if (i + 10 <= len) {
                bw.write(s.substring(i, i + 10) + "\n");
            } else {
                bw.write(s.substring(i, len) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

}
