import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static Maps[][] map;
	static int[] bcPerformances;
	static int[] userInfoA;
	static int[] userInfoB;
	static int answer;
	static int[] curUserBC;
	static int maxChargeA;
	static int maxChargeB;
	static int maxSum;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int tc = 1; tc <= T; tc++) {
        	st = new StringTokenizer(br.readLine());
        	int M = Integer.parseInt(st.nextToken());
        	int A = Integer.parseInt(st.nextToken());
        	map = new Maps[10][10];
        	userInfoA = new int[M];
        	userInfoB = new int[M];
        	bcPerformances = new int[A + 1];
        	curUserBC = new int[2];
        	answer = 0;
        	
        	//지도 초기화
        	for (int i = 0; i < 10; i++) {
        		for (int j = 0; j < 10; j++) {
        			map[i][j] = new Maps();
        		}
        	}
        	
        	//사용자 A 이동정보 초기화
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < M; i++) {
        		userInfoA[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	//사용자 B 이동정보 초기화
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < M; i++) {
        		userInfoB[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	//BC 초기화
        	for (int i = 1; i <= A; i++) {
        		st = new StringTokenizer(br.readLine());
        		int x = Integer.parseInt(st.nextToken()) - 1;
        		int y = Integer.parseInt(st.nextToken()) - 1;
        		int C = Integer.parseInt(st.nextToken());
        		int P = Integer.parseInt(st.nextToken());
        		
        		bcPerformances[i] = P;
        		installBC(y, x, C, i);
        	}
        	
        	moveUser(M);
        	sb.append("#").append(tc).append(' ').append(answer).append("\n");
        }
        System.out.println(sb);
	}
	
	public static void moveUser(int M) {
		User A = new User(0, 0);
		User B = new User(9, 9);
		
		for (int i = 0; i <= M; i++) {
			charge(A, B);
			if (i == M) {
				break;
			}
			A.move(userInfoA[i]);
			B.move(userInfoB[i]);
		}
	}
	
	public static void charge(User A, User B) {
//		maxChargeA = 0;
//		maxChargeB = 0;
		maxSum = 0;
		combi(0, A, B);
		answer += maxSum;
	}
	
	public static void combi(int depth, User A, User B) {
		if (depth == 2) {
			int[] cnt = new int[bcPerformances.length];
			int bcOfA = curUserBC[0];
			int bcOfB = curUserBC[1];
			cnt[bcOfA]++;
			cnt[bcOfB]++;
			int ChargeA = Math.max(maxChargeA, bcPerformances[bcOfA] / cnt[bcOfA]);
			int ChargeB = Math.max(maxChargeB, bcPerformances[bcOfB] / cnt[bcOfB]);
			maxSum = Math.max(maxSum, ChargeA + ChargeB);
			return;
		}
		
		//사용자 A
		if (depth == 0) {
			if (map[A.y][A.x].isEmpty()) {
				curUserBC[depth] = 0;
				combi(depth + 1, A, B);
			} else {
				for (int bcNum : map[A.y][A.x].bcList) {
					curUserBC[depth] = bcNum;
					combi(depth + 1, A, B);
				}
			}
		} else if (depth == 1) { // 사용자 B
			if (map[B.y][B.x].isEmpty()) {
				curUserBC[depth] = 0;
				combi(depth + 1, A, B);
			} else {
				for (int bcNum : map[B.y][B.x].bcList) {
					curUserBC[depth] = bcNum;
					combi(depth + 1, A, B);
				}
			}
		}
	}

	public static void installBC(int y, int x, int C, int n) {
		int dx = 0;
		int tmp = 1;
		for (int i = y - C; i <= y + C; i++) {
			if (0 <= i && i < 10) {
				map[i][x].add(n);
				
				//중앙의 왼쪽 설치
				for (int j = 1; j <= dx && (x - j) >= 0; j++) {
					map[i][x - j].add(n);
				}
				
				//중앙의 오른쪽 설치
				for (int j = 1; j <= dx && (x + j) < 10; j++) {
					map[i][x + j].add(n);
				}
			}
			if (dx == C) {
				tmp *= -1;
			}
			dx += tmp;
		}
	}
}

class Maps {
	List<Integer> bcList;
	
	Maps() {
		this.bcList = new ArrayList<>();
	}
	
	public void add(int n) {
		this.bcList.add(n);
	}
	
	public boolean isEmpty() {
		return bcList.isEmpty();
	}
	
//	public void changeBCInfo(BatteryCharger[] bc) {
//		for (int bcNum : bcList) {
//			bc[bcNum].addUser();
//		}
//	}
	
	public String toString() {
		return bcList.toString();
	}
}

class User {
	int x;
	int y;
	
	User(int y, int x) {
		this.x = x;
		this.y = y;
	}
	
	public void move(int dir) {
		if (dir == 1) y--;
		else if (dir == 2) x++;
		else if (dir == 3) y++;
		else if (dir == 4) x--;
	}
}

//class BatteryCharger{
//	
//	int performance;
//	int currentUser;
//	
//	BatteryCharger(int P) {
//		this.performance = P;
//	}
//	
//	public int getPerformance() {
//		return performance / currentUser;
//	}
//	
//	public void addUser() {
//		this.currentUser++;
//	}
//	
//	public void removeUser() {
//		this.currentUser++;
//	}
//}