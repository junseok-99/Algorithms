import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        BigInteger num1 = new BigInteger(arr[0]);
        BigInteger num2 = new BigInteger(arr[1]);

        bw.write(num1.add(num2)+"");

        bw.flush();
        bw.close();
    }

}
