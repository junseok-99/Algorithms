import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));

        br.write("Hello World!");
        br.flush();
        br.close();
    }

}
