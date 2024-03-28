import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int M;
	static int C;
	static int[][] map;
	static List<HoneyCup> honeyList;
	static int answer;
	static int[] picked;
	static boolean[] isSelected;
	static int maxProfit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			honeyList = new ArrayList<>();
			answer = Integer.MIN_VALUE;
			picked = new int[2];
			isSelected = new boolean[M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//이익 계산
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - M; j++) {
					int[] cup = new int[M];

					for (int k = 0; k < M; k++) {
						cup[k] = map[i][j + k];
					}
					maxProfit = 0;
					subSet(0, cup);
					if (maxProfit == 0) continue;
					
					honeyList.add(new HoneyCup(maxProfit, i, j, j + M - 1));
				}
			}
			
			combi(0, 0);
			sb.append("#").append(tc).append(' ').append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void combi(int depth, int idx) {
		if (depth == 2) {
			if (!isCollapse()) {
				int profit1 = honeyList.get(picked[0]).profit;
				int profit2 = honeyList.get(picked[1]).profit;
				answer = Math.max(answer, profit1 + profit2);
			}
			return;
		}
		
		for (int i = idx; i < honeyList.size(); i++) {
			picked[depth] = i;
			combi(depth + 1, i + 1);
		}
	}
	
	public static void subSet(int depth, int[] cup) {
		if (depth == M) {
			int sum = 0;
			int profit = 0;
			for (int i = 0; i < M; i++) {
				if (isSelected[i]) {
					sum += cup[i];
					profit += (int) Math.pow(cup[i], 2);
				}
			}
			if (sum <= C)
				maxProfit = Math.max(maxProfit, profit);
			return;
		}
		
		isSelected[depth] = true;
		subSet(depth + 1, cup);
		isSelected[depth] = false;
		subSet(depth + 1, cup);
	}
	
	public static boolean isCollapse() {
		int s1 = honeyList.get(picked[0]).start;
		int e1 = honeyList.get(picked[0]).end;
		int s2 = honeyList.get(picked[1]).start;
		int e2 = honeyList.get(picked[1]).end;
		int r1 = honeyList.get(picked[0]).r;
		int r2 = honeyList.get(picked[1]).r;
		
		if (r1 != r2) return false;
		if (s1 <= s2 && s2 <= e1) return true;
		if (s1 <= s2 && s2 <= e1) return true;
		return false;
	}
	
	public static int calcProfit(int[] cup) {
		int sum = 0;
		int profit = 0;
		Arrays.sort(cup);
		for (int i = M - 1; i >= 0; i--) {
			int honey = cup[i];
			if (sum + honey > C) break;
			sum += honey;
			profit += (int)Math.pow(honey, 2);
		}
		return profit;
	}
}

class HoneyCup {
	int start;
	int r;
	int end;
	int profit;
	
	HoneyCup(int profit, int r, int start, int end) {
		this.profit = profit;
		this.r = r;
		this.start = start;
		this.end = end;
	}
}