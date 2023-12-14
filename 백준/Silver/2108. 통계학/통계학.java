import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
            sum += arr[i];
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        System.out.println(Math.round((double)sum / N));
        Arrays.sort(arr);
        System.out.println(arr[N / 2]);

        List<Integer> li = new ArrayList<Integer>();
        int max = -1;
        for (Integer n : map.keySet()) {
            if (max < map.get(n)) {
                max = map.get(n);
                li.clear();
            }
            if (max == map.get(n)) {
                li.add(n);
            }
        }
        Collections.sort(li);
        System.out.println(li.size() > 1 ? li.get(1) : li.get(0));
        System.out.println(arr[N-1] - arr[0]);
    }
}