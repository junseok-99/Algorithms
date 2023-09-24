import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<List<String>> list = new ArrayList<>();

        for(int i=0;i<5;i++) {
            String s = br.readLine();

            for(int j=0;j<s.length();j++) {
                if (j >= list.size()) {
                    list.add(new ArrayList<>());
                }
                list.get(j).add(Character.toString(s.charAt(j)));
            }
        }

        for(int i=0;i<list.size();i++) {
            for(String s: list.get(i)) {
                System.out.print(s);
            }
        }

    }

}
