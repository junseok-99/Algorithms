import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> idxStack = new Stack<>();
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		for (int i = 0; i < N; i++)  {
			int n = Integer.parseInt(st.nextToken());
			
			while (!stack.isEmpty() && stack.peek() <= n) {
				stack.pop();
				idxStack.pop();
			}
			
			if (stack.isEmpty()) {
				sb.append("0 ");
			} else {
				sb.append(idxStack.peek()).append(' ');
			}
			stack.push(n);
			idxStack.push(i + 1);
		}
		System.out.println(sb);
	}

}