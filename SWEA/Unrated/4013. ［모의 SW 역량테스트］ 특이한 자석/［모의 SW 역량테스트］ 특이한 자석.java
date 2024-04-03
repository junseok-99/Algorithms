import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int K;
	static Gear[] gears;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(br.readLine());
			gears = new Gear[4];
			
			//톱니바퀴 초기화
			for (int i = 0; i < 4; i++) {
				gears[i] = new Gear(br.readLine());
			}
			
			//톱니바퀴 회전
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int gearNum = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				spin(gearNum - 1, dir);
			}
			
			//답 계산
			int answer = 0;
			for (int i = 0; i < 4; i++) {
				if (gears[i].getTop()) answer += (int) Math.pow(2, i);
			}
			sb.append("#").append(tc).append(' ').append(answer).append("\n");
		}
		System.out.println(sb);
	}

	//회전
	public static void spin(int num, int dir) {
		int l = num - 1;
		int r = num + 1;
		gears[num].isSpin = true;
		if (l >= 0) {
			if (gears[l].getRight() != gears[num].getLeft() && !gears[l].isSpin) {
				spin(l, dir * -1);
			}
		}
		if (r <= 3) {
			if (gears[r].getLeft() != gears[num].getRight() && !gears[r].isSpin) {
				spin(r, dir * -1);
			}
		}
		gears[num].spin(dir);
	}
}

class Gear {
	boolean[] poles = new boolean[8];
	boolean isSpin = false;
	
	Gear(String s) {
		StringTokenizer st = new StringTokenizer(s);
		for (int i = 0; i < 8; i++) {
			if (st.nextToken().charAt(0) == '1') poles[i] = true;
		}
	}
	
	//회전
	public void spin(int dir) {
		if (dir == 1) rightSpin();
		else if (dir == -1) leftSpin();
		isSpin = false;
	}
	
	//반시계 회전
	public void leftSpin() {
		boolean[] tmp = new boolean[8];
		for (int i = 0; i < 8; i++) {
			tmp[i] = poles[(i + 1) % 8];
		}
		poles = tmp;
	}
	
	//시계 회전
	public void rightSpin() {
		boolean[] tmp = new boolean[8];
		for (int i = 0; i < 8; i++) {
			tmp[i] = poles[(i + 7) % 8];
		}
		poles = tmp;
	}
	
	public boolean getLeft() {
		return poles[6];
	}
	
	public boolean getRight() {
		return poles[2];
	}
	
	public boolean getTop() {
		return poles[0];
	}
}