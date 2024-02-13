import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//mem: 14,900kb , time: 204ms
public class Main {

	static int N;
	static int M;
	static List<Point> houses = new ArrayList<>();
	static List<Point> chickens = new ArrayList<>();
	static Point[] points;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		points = new Point[M];
		
		//집과 치킨집의 좌표를 저장함
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1) houses.add(new Point(i, j));
				else if (n == 2) chickens.add(new Point(i, j));
			}
		}
		
		combi(0, 0, chickens.size());
		
		System.out.println(answer);
	}

	//도시에 있는 치킨집의 좌표들 중에서 M개를 고른다
	public static void combi(int idx, int depth, int maxIdx) {
		if (depth == M) {
			answer = Math.min(answer, minChickenStreet());
			return;
		}
		
		for (int i = idx; i < maxIdx; i++) {
			points[depth] = chickens.get(i);
			combi(i + 1, depth + 1, maxIdx);
		}
	}
	
	//고른 M개의 치킨집과 도시의 모든 집의 치킨 거리를 계산한다
	public static int minChickenStreet() {
		int distanceSum = 0;
		
		for (Point homeP : houses) {
			int minDistance = Integer.MAX_VALUE;
			for (Point chickenP : points) {
				minDistance = Math.min(minDistance, homeP.calcTwoPointDistance(chickenP));
			}
			distanceSum += minDistance;
			if (distanceSum > answer) return Integer.MAX_VALUE;
		}
		return distanceSum;
	}
}

class Point {
	int r;
	int c;
	
	Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
	public int calcTwoPointDistance(Point p) {
		return Math.abs(this.r - p.r) + Math.abs(this.c - p.c);
	}
}
