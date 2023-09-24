import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            String s = br.readLine();
            String ret = Character.toString(s.charAt(0)) + Character.toString(s.charAt(s.length()-1));
            System.out.println(ret);
        }
    }
}
