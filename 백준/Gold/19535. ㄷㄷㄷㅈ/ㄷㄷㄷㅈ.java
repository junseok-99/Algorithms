import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> tree = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        long ㄷ = 0;
        long ㅈ = 0;

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            long n = tree.get(i).size();

            if (n >= 3) {
                ㅈ += ((n * (n - 1) * (n - 2)) / 6);
            }

            visited[i] = true;
            for (int neighbor : tree.get(i)) {
                if (!visited[neighbor]) {
                    long neighborSize = tree.get(neighbor).size();
                    ㄷ += (n - 1) * (neighborSize - 1);
                }
            }
        }

        if (ㄷ > ㅈ * 3) {
            System.out.println("D");
        } else if (ㄷ < ㅈ * 3) {
            System.out.println("G");
        } else if (ㄷ == (ㅈ * 3)) {
            System.out.println("DUDUDUNGA");
        }
    }

}