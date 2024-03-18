import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, String> soloMap = new HashMap<>();
        Map<String, List<String>> groupMap = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String group = br.readLine();
            groupMap.put(group, new ArrayList<>());

            int num = Integer.parseInt(br.readLine());
            for (int j = 0; j < num; j++) {
                String solo = br.readLine();
                groupMap.get(group).add(solo);
                soloMap.put(solo, group);
            }
            Collections.sort(groupMap.get(group));
        }

        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            int flag = Integer.parseInt(br.readLine());
            if (flag == 0) {
                for (String solo : groupMap.get(question)) {
                    sb.append(solo).append("\n");
                }
            } else if (flag == 1) sb.append(soloMap.get(question)).append("\n");
        }
        System.out.println(sb);
    }
}