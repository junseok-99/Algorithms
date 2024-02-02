import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static int N; //재료의 수
	static int L; //제한 칼로리
	static PriorityQueue<Ingredient> pq = new PriorityQueue<>();
	static Ingredient[] ig;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			pq.clear();
			ig = new Ingredient[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int taste = Integer.parseInt(st.nextToken());
				int cal = Integer.parseInt(st.nextToken());
				ig[i] = new Ingredient(taste, cal);
			}
			
			dfs(0, 0, 0, 0);
			sb.append("#").append(tc).append(' ').append(pq.poll().taste).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int idx, int depth, int taste, int cal) {
		if (cal > L) {
			return;
		}
		
		if (depth >= 1) {
			pq.add(new Ingredient(taste, cal));
		}
		
		for (int i = idx; i < N; i++) {
			int t = ig[i].taste;
			int c = ig[i].calorie;
			dfs(i + 1, depth + 1, taste + t, cal + c);
		}
	}
}

class Ingredient implements Comparable<Ingredient>{
	int taste; //맛점수
	int calorie; //칼로리
	
	public Ingredient(int taste, int calorie) {
		this.taste = taste;
		this.calorie = calorie;
	}

	@Override
	public int compareTo(Ingredient o) {
		return o.taste - this.taste;
	}
}