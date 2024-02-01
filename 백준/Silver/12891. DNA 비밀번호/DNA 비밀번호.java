import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static Map<String, Integer> map = new HashMap<>();
	static int[] minNums = new int[4];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int l = 0;
		int r = P - 1;
		long answer = 0;
		StringBuilder s = new StringBuilder(br.readLine());
		
		map.put("A", 0);
		map.put("C", 0);
		map.put("G", 0);
		map.put("T", 0);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			minNums[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < P; i++) {
			String tmp = s.substring(i, i + 1);
			increaseCount(tmp);
		}
		
		while (l <= r) {
			if (validCharCount()) {
				++answer;
			}
			
			decreaseCount(s.substring(l, l + 1));
			l++;
			
			r++;
			if (r == S) break;
			increaseCount(s.substring(r, r + 1));
		}
		System.out.println(answer);
	}
	
	public static void increaseCount(String s) {
		if (map.containsKey(s)) {
			map.put(s, map.get(s) + 1);
		}
	}
	
	public static void decreaseCount(String s) {
		if (map.containsKey(s)) {
			map.put(s, map.get(s) - 1);
		}
	}
	
	public static boolean validCharCount() {
		String[] tmp = {"A", "C", "G", "T"};
		
		for (int i = 0; i < 4; i++) {
			int curCnt = map.get(tmp[i]);
			if (curCnt < minNums[i]) {
				return false;
			}
		}
		return true;
	}
}