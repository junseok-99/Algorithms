import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			List<String> list = new LinkedList<>();
			
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) { //원본 암호문 담기
				list.add(st.nextToken());
			}
			
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) { //명령어 처리
				String s = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				List<String> tmp = new LinkedList<>();
				for (; y > 0; y--) { //
					tmp.add(st.nextToken());
				}
				//암호문 수정하기
				list.addAll(x, tmp);
			}
			
			sb.append("#").append(tc).append(' ');
			for (int j = 0; j < 10; j++) {
				sb.append(list.get(j)).append(' ');
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}