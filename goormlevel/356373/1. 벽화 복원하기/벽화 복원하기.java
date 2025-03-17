import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String k = br.readLine();
		
		StringBuilder s = new StringBuilder();
		int first = 1;
		
		while (true) {
			s.append(Integer.toString(first));
			
			int idx = 0;
			boolean flag = false;
			for (int i = 0; i < s.length(); i++) {
				char c = k.charAt(idx);
				char co = s.charAt(i);
				
				if (c == co) ++idx;
				if (idx == k.length()) {
					flag = true;
					break;
				}
			}
			
			if (flag) {
				System.out.println(first);
				break;
			}
			first++;
		}
	}
}