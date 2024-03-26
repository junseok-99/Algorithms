import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> cntMap = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.length() < M) continue;
            cntMap.put(s, cntMap.getOrDefault(s, 0) + 1);
        }

        List<String> list = new LinkedList<>(cntMap.keySet());
        Collections.sort(list, (s1, s2) -> {
            int cnt1 = cntMap.get(s1);
            int cnt2 = cntMap.get(s2);
            if (cnt1 == cnt2) {
                int len1 = s1.length();
                int len2 = s2.length();
                if (len1 == len2) {
                    return s1.compareTo(s2);
                }
                return Integer.compare(len2, len1);
            }
            return Integer.compare(cnt2, cnt1);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }

}