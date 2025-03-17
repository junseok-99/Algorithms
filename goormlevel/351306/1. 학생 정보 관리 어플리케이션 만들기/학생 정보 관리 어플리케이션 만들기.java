import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<String> li = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String m = st.nextToken();
			String s = st.nextToken();
			
			if (m.equals("add")) {
				li.add(s);
			} else if (m.equals("find")) {
				int cnt = 0;
				
				for (String name : li) {
					if (name.startsWith(s)) ++cnt;
				}
				System.out.println(cnt);
			}
		}
	}
}