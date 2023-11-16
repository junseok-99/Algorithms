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

		for (int i=1;i<=T;i++) {
			String numStr = Integer.toString(i);
			String[] tmp = {"3", "6", "9"};
			for (String s: tmp) {
				numStr = numStr.replace(s, "-");
			}
			
			if (numStr.contains("-")) {
				numStr = numStr.replaceAll("[0-9]", "");
			}
			System.out.print(numStr + " ");
		}
	}
}