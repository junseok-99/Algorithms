import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        List<String> list = List.of("dz=", "s=", "z=", "c=", "d-", "lj", "nj", "c-");
        for (String str : list) {
            s = s.replace(str, "*");
        }
        System.out.println(s.length());
    }
}
