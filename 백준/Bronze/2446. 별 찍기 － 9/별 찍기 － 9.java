import java.io.*;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int max = n * 2 - 1;

        for(int i=0;i<max/2;i++) {
            for(int j=i%n;j>0;j--) {
                System.out.print(" ");
            }

            for(int j=max-(i*2);j>0;j--) {
                System.out.print("*");
            }

            System.out.println();
        }

        for(int i=max/2;i>=0;i--) {
            for(int j=i%n;j>0;j--) {
                System.out.print(" ");
            }

            for(int j=max-(i*2);j>0;j--) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
