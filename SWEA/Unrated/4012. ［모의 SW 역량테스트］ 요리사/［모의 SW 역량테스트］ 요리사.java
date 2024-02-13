import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] map;
	static int N;
	static boolean[] visited;
	static int minSynergy;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N];
			map = new int[N][N];
			minSynergy = Integer.MAX_VALUE;
			
			//시너지 초기화
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			combi(0, 0);
			sb.append("#").append(tc).append(' ').append(minSynergy).append("\n");
		}
		System.out.println(sb);
	}

	//N개중 N / 2개를 고르는 경우 계산
	public static void combi(int idx, int depth) {
		
		//N / 2개를 고른 경우 요리 시작
		if (depth == N / 2) {
			cook();
			return;
		}
		
		for (int i = idx; i < N; i++) {
			visited[i] = true;
			combi(i + 1, depth + 1);
			visited[i] = false;
		}
	}
	
	//요리 시작
	public static void cook() {
		int[] foodA = new int[N / 2];
		int[] foodB = new int[N / 2];
		int a = 0;
		int b = 0;
		
		//음식A와 음식B에 들어가는 재료 파악
		for (int i = 0; i < N; i++) {
			if (visited[i]) foodA[a++] = i;
			else foodB[b++] = i;
		}
		
		int synergyA = calcSynergy(foodA, N / 2);
		int synergyB = calcSynergy(foodB, N / 2);
		
		minSynergy = Math.min(minSynergy, Math.abs(synergyA - synergyB));
	}
	
	//음식에 들어가는 재료들의 시너지 계산
	public static int calcSynergy(int[] ingredients, int len) {
		int synergy = 0;
		
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				int ingredient1 = ingredients[i];
				int ingredient2 = ingredients[j];
				synergy += map[ingredient1][ingredient2];
				synergy += map[ingredient2][ingredient1];
			}
		}
		return synergy;
	}
}
