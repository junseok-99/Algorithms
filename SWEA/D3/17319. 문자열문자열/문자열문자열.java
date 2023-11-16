import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int length = sc.nextInt();
			String str = sc.next();
			
			String front = str.substring(0, length / 2);
			String back = str.substring(length / 2, length);
			
			if (front.equals(back)) {
				outputAnswer(test_case, "Yes");
			} else {
				outputAnswer(test_case, "No");
			}
		}
	}
	
	public static void outputAnswer(int count, String answer) {
		System.out.println("#" + count + " " + answer);
	}
}