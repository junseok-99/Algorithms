import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] arr = new int[100];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			int dumpNum = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			recur(dumpNum);
			int answer = arr[99] - arr[0];
			System.out.println("#" + tc + " " + answer);
		}
		
		
	}
	
	public static void recur(int dumpNum) {
		Arrays.sort(arr);
		int sub = arr[99] - arr[0];
		
		if (dumpNum == 0 || sub == 1) {
			return;
		}
		
		arr[99]--;
		arr[0]++;
		recur(dumpNum - 1);
	}
}
