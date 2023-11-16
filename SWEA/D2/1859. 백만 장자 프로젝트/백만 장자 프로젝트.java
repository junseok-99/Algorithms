import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws IOException
	{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int length = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			long sum = calcProfit(length, str);
			outputAnswer(test_case, sum);
		}
	}
	
	public static long calcProfit(int length, String str) {
		int[] arr = new int[length];
		StringTokenizer st = new StringTokenizer(str);
		Queue<Integer> q = new LinkedList<>();
		
		for (int i=0;i<length;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long sum = 0;
		int maxPrice = 0;
		
		for (int i=length - 1;i>-1;i--) {
			if (maxPrice < arr[i]) {
				maxPrice = arr[i];
			}
			sum += (long)(maxPrice - arr[i]);
		}
		
		return sum;
	}
	
	public static void outputAnswer(int count, long answer) {
		System.out.println("#" + count + " " + answer);
	}
}