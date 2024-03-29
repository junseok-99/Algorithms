import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//mem: 95,816 kb , time: 587 ms
public class Solution {

	static int N;
	static int W;
	static int H;
	static int answer;
	static int[] dropIdxs;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			answer = Integer.MAX_VALUE;
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			dropIdxs = new int[N];
			map = new int[H][W];
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			permu(0);
			
			sb.append("#").append(tc).append(' ').append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	//떨어트릴 위치 중복 순열로 뽑기
	public static void permu(int depth) {
		if (answer == 0) return;
		if (depth == N) {
			drop();
			return;
		}
		
		for (int i = 0; i < W; i++) {
			dropIdxs[depth] = i;
			permu(depth + 1);
		}
	}
	
	//벽돌 부수기
	public static void breakWall(int y, int x, int[][] copyMap) {
		if (invalidRange(x, y) || copyMap[y][x] == 0) return;
		
		int range = copyMap[y][x] - 1;
		copyMap[y][x] = 0;
		
		for (int i = 1; i <= range; i++) {
			breakWall(y + i, x, copyMap); //하 
			breakWall(y - i, x, copyMap); //상
			breakWall(y, x + i, copyMap); //우
			breakWall(y, x - i, copyMap); //좌
		}
	}
	
	//벽돌 내리기
	public static void downWall(int[][] copyMap) {
		Deque<Integer> q = new ArrayDeque<>();
		
		for (int x = 0; x < W; x++) {
			for (int y = H - 1; y >= 0; y--) {
				if (copyMap[y][x] > 0) q.add(copyMap[y][x]);
				copyMap[y][x] = 0;
			}
			
			int size = q.size();
			for (int i = 1; i <= size; i++) {
				copyMap[H - i][x] = q.poll();
			}
		}
	}
	
	//구슬 떨어트리기
	public static void drop() {
		int[][] copyMap = getCopyMap();
		
		for (int x : dropIdxs) {
			for (int y = 0; y < H; y++) {
				if (copyMap[y][x] > 0) {
					breakWall(y, x, copyMap);
					downWall(copyMap);
					break;
				}
			}
		}
		answer = Math.min(answer, remainWallCount(copyMap));
	}
	
	public static int remainWallCount(int[][] copyMap) {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (copyMap[i][j] > 0) ++count;
			}
		}
		return count;
	}
	
	public static int[][] getCopyMap() {
		int[][] copyMap = new int[H][W];
		for (int i = 0; i < H; i++) {
			System.arraycopy(map[i], 0, copyMap[i], 0, W);
		}
		return copyMap;
	}
	
	public static boolean invalidRange(int x, int y) {
		return x < 0 || x >= W || y < 0 || y >= H;
	}
}